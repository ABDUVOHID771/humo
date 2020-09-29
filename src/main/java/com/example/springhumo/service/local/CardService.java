package com.example.springhumo.service.local;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.humo.response.BalanceResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.CheckSmsEnabledResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.ListCustomer;
import com.example.springhumo.model.dto.humo.response.ListCustomerCard;
import com.example.springhumo.model.entity.Bank;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.repository.CardRepository;
import com.example.springhumo.util.CardUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private Logger logger = LogManager.getLogger(CardService.class);
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private BankService bankService;

    public CardService() {
    }

    public Optional<Card> getCardById(Integer id) {
        return this.cardRepository.findById(id);
    }

    public Optional<Card> getCardByToken(String token) {
        return this.cardRepository.findByToken(token);
    }

    public Card saveCard(Card card) {
        return (Card)this.cardRepository.save(card);
    }

    public Pair<Result, Card> saveCard(String holder, String pan, String expiry, Integer status, String phone, String cardName, String cardTheme, Boolean sms, Long balance) {
        Optional<Bank> bank = this.bankService.getBankByPan(pan);
        if (!bank.isPresent()) {
            return Pair.of(ApiResults.ERR_004, null);
        } else {
            String token = CardUtil.generateCardToken(pan, expiry);
            String maskedPan = CardUtil.maskPan(pan);
            Pair<Result, String> pair = CardUtil.encode(pan);
            if (!((Result)pair.getFirst()).getCode().equalsIgnoreCase("OK")) {
                return Pair.of(ApiResults.ERR_004, null);
            } else {
                String encPan = (String)pair.getSecond();
                Optional<Card> dbCard = this.getCardByToken(token);
                Card card = dbCard.isPresent() ? (Card)dbCard.get() : new Card();
                card.setPan(maskedPan);
                card.setToken(token);
                card.setHolder(holder);
                card.setName(cardName.isEmpty() ? card.getName() : cardName);
                card.setTheme(cardTheme.isEmpty() ? card.getTheme() : cardTheme);
                card.setPhone(phone);
                card.setSms(sms);
                card.setStatus(status);
                card.setBalance(balance == null ? card.getBalance() : balance);
                card.setBank((Bank)bank.get());
                card.setEncPan(encPan);
                card.setExpDate(expiry);
                Card savedCard = (Card)this.cardRepository.save(card);
                return Pair.of(ApiResults.OK, savedCard);
            }
        }
    }

    public Pair<Result, Card> saveCard(String pan, String expiry, ListCustomer customer, CheckSmsEnabledResponseEnvelopDto checkResponse) {
        String holder = checkResponse.getCardholderName();
        Integer status = NumberUtils.isParsable(customer.getStatus()) ? Integer.valueOf(customer.getStatus()) : null;
        String phone = checkResponse.getPhone().getMsisdn().replaceAll("\\+", "");
        String cardName = "";
        String cardTheme = "";
        Boolean smsEnabled = checkResponse.getState().equalsIgnoreCase("on") ? Boolean.TRUE : Boolean.FALSE;
        return this.saveCard(holder, pan, expiry, status, phone, cardName, cardTheme, smsEnabled, (Long)null);
    }

    public Pair<Result, Card> updateBalance(String pan, BalanceResponseEnvelopDto balanceResponseEnvelopDto, Boolean exceedsPinTry) {
        Pair<Result, String> pair = CardUtil.encode(pan);
        if (!((Result)pair.getFirst()).getCode().equalsIgnoreCase("OK")) {
            return Pair.of(ApiResults.ERR_004, null);
        } else {
            String encPan = (String)pair.getSecond();
            Optional<Card> card = this.cardRepository.findByEncPan(encPan);
            if (!card.isPresent()) {
                return Pair.of(ApiResults.ERR_004, null);
            } else {
                ((Card)card.get()).setBalance(balanceResponseEnvelopDto.getBalance().getAvailableAmount());
                ((Card)card.get()).setUpdatedDate(LocalDateTime.now());
                if (balanceResponseEnvelopDto.getCardStatusError().getResult() != ApiResults.OK) {
                    ((Card)card.get()).setStatus(1);
                } else {
                    ((Card)card.get()).setStatus(0);
                }

                if (exceedsPinTry) {
                    ((Card)card.get()).setStatus(1);
                }

                Card savedCard = (Card)this.cardRepository.save(card.get());
                return Pair.of(ApiResults.OK, savedCard);
            }
        }
    }

    public Card generateTemplateCardFromCustomer(ListCustomer customer, BalanceResponseEnvelopDto balanceResponseEnvelopDto) {
        String maskedPan = CardUtil.maskPan(customer.getCard());
        Optional<Bank> bank = this.bankService.getBankByPan(customer.getCard());
        Card card = new Card();
        card.setPan(maskedPan);
        card.setToken(CardUtil.generateCardToken(customer.getCard(), balanceResponseEnvelopDto.getCard().getExpiry()));
        card.setHolder(balanceResponseEnvelopDto.getCard().getNameOnCard());
        card.setName(customer.getFNames());
        card.setTheme("");
        card.setExpDate(balanceResponseEnvelopDto.getCard().getExpiry());
        card.setPhone(customer.getMobilePhone());
        card.setSms(Boolean.FALSE);
        card.setStatus(balanceResponseEnvelopDto.getCardStatusError().getId());
        card.setBalance(balanceResponseEnvelopDto.getBalance().getAvailableAmount());
        card.setBank((Bank)bank.orElse(new Bank()));
        card.setEncPan((String)CardUtil.encode(customer.getCard()).getSecond());
        return card;
    }

    private Integer defineCardStatus(ListCustomer customer, Optional<ListCustomerCard> customerCard, Integer pinStatus) {
        this.logger.info("Card status in listCustomer:" + customer.getStatus());
        Integer status = NumberUtils.isParsable(customer.getStatus()) ? Integer.valueOf(customer.getStatus()) : null;
        if (customerCard.isPresent()) {
            this.logger.info("Card status in listCustomerCard:" + ((ListCustomerCard)customerCard.get()).getStatus1());
            this.logger.info("Stop cause listCustomerCard:" + ((ListCustomerCard)customerCard.get()).getStopCause());
            status = NumberUtils.isParsable(((ListCustomerCard)customerCard.get()).getStatus1()) ? Integer.valueOf(((ListCustomerCard)customerCard.get()).getStatus1()) : null;
        }

        if (pinStatus != 0) {
            this.logger.info("Card status in queryCardInfo:" + pinStatus);
            status = pinStatus;
        }

        return status;
    }
}
