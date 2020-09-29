package com.example.springhumo.service.api;

//CHANGED
import com.example.springhumo.constant.HumoAction;
import com.example.springhumo.constant.HumoError;
import com.example.springhumo.exception.CardNotFoundException;
import com.example.springhumo.exception.IncorrectPanException;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.CardInfoDataToMapUzcard;
import com.example.springhumo.model.dto.CardInfoDto;
import com.example.springhumo.model.dto.humo.response.BalanceResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.CheckSmsEnabledResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.ListCustomer;
import com.example.springhumo.model.dto.uzCard.*;
import com.example.springhumo.model.entity.Card;
import com.example.springhumo.model.entity.HumoClient;
import com.example.springhumo.service.local.CardService;
import com.example.springhumo.service.local.ClientService;
import com.example.springhumo.util.CardUtil;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HumoCardService {
    private Logger logger = LogManager.getLogger(HumoCardService.class);
    @Value("${api.humo.balance}")
    private String balanceUrl;
    @Value("${api.humo.payment.and.confirm}")
    private String payAndConfirmUrl;
    @Value("${api.humo.export.and.import}")
    private String exportAndImport;
    @Value("${humo.username}")
    private String username;
    @Autowired
    private WebClientService manager;
    @Autowired
    private CardService cardService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private HumoWsService humoWsService;

    public HumoCardService() {
    }

    public ResponseEntity<?> p2pInfo(String pan) throws TimeoutException {
        ResponseEntity<?> responseEntity = this.cardInfo(pan);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return responseEntity;
        } else {
            CardInfoDto result = (CardInfoDto)responseEntity.getBody();
            CardInfoDataToMapUzcard uzcardLikeResponse = new CardInfoDataToMapUzcard(result);
            return ResponseEntity.ok(uzcardLikeResponse);
        }
    }

    public ResponseEntity<?> byToken(String token) throws TimeoutException {
        String decPan = this.getPanByToken(token);
        return this.cardInfo(decPan);
    }

    public ResponseEntity<?> byToken(UzCardCardsRequestDto<CardsGetParam> requestDto) throws TimeoutException {
        String[] tokens = ((CardsGetParam)requestDto.getParams()).getIds();
        List<UzCardCardsResult> cardList = new ArrayList();
        String[] var4 = tokens;
        int var5 = tokens.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String token = var4[var6];
            ResponseEntity<?> cardResponseEntity = this.getCardInfoByToken(token);
            if (cardResponseEntity.getStatusCode() != HttpStatus.OK) {
                return cardResponseEntity;
            }

            cardList.add(new UzCardCardsResult((Card)cardResponseEntity.getBody()));
        }

        return ResponseEntity.ok(new UzCardCardsResponseDto(cardList, requestDto.getJsonrpc(), requestDto.getId()));
    }

    public ResponseEntity<?> cardInfo(String pan) throws TimeoutException {
        ResponseEntity<?> cardResponseEntity = this.getCardInfoAndUpdate(pan);
        Card card = (Card)cardResponseEntity.getBody();
        if (card == null) {
            return ResponseEntity.notFound().build();
        } else {
            CardInfoDto result = new CardInfoDto(card);
            return ResponseEntity.ok(result);
        }
    }

    public ResponseEntity<?> cardInfo(UzCardCardsRequestDto<CardsNewParam> requestDto) throws TimeoutException {
        ResponseEntity<?> cardResponseEntity = this.getCardInfoAndUpdate(((CardsNewParam)requestDto.getParams()).getCard().getPan());
        if (cardResponseEntity.getStatusCode() != HttpStatus.OK) {
            return cardResponseEntity;
        } else {
            Card card = (Card)cardResponseEntity.getBody();
            if (((CardsNewParam)requestDto.getParams()).getCard().getExpiry() != null && !((CardsNewParam)requestDto.getParams()).getCard().getExpiry().isEmpty() && !((CardsNewParam)requestDto.getParams()).getCard().getExpiry().equals(card.getExpDate())) {
                return ResponseEntity.badRequest().body("wrong card expiry");
            } else {
                UzCardCardsResponseDto responseDto = new UzCardCardsResponseDto(new UzCardCardsResult(card), requestDto.getJsonrpc(), requestDto.getId());
                return ResponseEntity.ok(responseDto);
            }
        }
    }

    private ResponseEntity<?> getCardInfoByToken(String token) throws TimeoutException {
        Optional<Card> card = this.cardService.getCardByToken(token);
        if (!card.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            String decPan = CardUtil.decode(((Card)card.get()).getEncPan());
            HumoClient client = ((Card)card.get()).getHumoClient();
            if (client != null && client.getClientB() != null) {
                ResponseEntity<BalanceResponseEnvelopDto> balanceResponseEnvelopDtoResponse = this.getBalance(decPan);
                if (balanceResponseEnvelopDtoResponse.getStatusCode() != HttpStatus.OK) {
                    return balanceResponseEnvelopDtoResponse;
                } else {
                    String bankCode = CardUtil.getBankCode(decPan);
                    ResponseEntity<CheckSmsEnabledResponseEnvelopDto> checkSmsEnabled = this.checkSmsEnabled(client.getClientId(), bankCode);
                    if (checkSmsEnabled.getStatusCode() != HttpStatus.OK) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
                    } else {
                        Boolean exceeds = this.humoWsService.exceedsPinTry(decPan);
                        Pair<Result, Card> updatedCard = this.cardService.updateBalance(decPan, (BalanceResponseEnvelopDto)balanceResponseEnvelopDtoResponse.getBody(), exceeds);
                        return !((Result)updatedCard.getFirst()).getCode().equalsIgnoreCase("OK") ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(updatedCard.getFirst()) : ResponseEntity.ok(updatedCard.getSecond());
                    }
                }
            } else {
                return this.getCardInfoAndUpdate(decPan);
            }
        }
    }

    private ResponseEntity<?> getCardInfoAndUpdate(String pan) throws TimeoutException {
        if (pan != null && !pan.isEmpty() && pan.startsWith("9860")) {
            ResponseEntity<ListCustomer> listCustomerResponse = this.humoWsService.listCustomers(pan);
            if (listCustomerResponse.getStatusCode() != HttpStatus.OK) {
                return listCustomerResponse;
            } else {
                ListCustomer customer = (ListCustomer)listCustomerResponse.getBody();
                ResponseEntity<BalanceResponseEnvelopDto> balanceResponseEnvelopDtoResponse = this.getBalance(pan);
                if (balanceResponseEnvelopDtoResponse.getStatusCode() != HttpStatus.OK) {
                    return balanceResponseEnvelopDtoResponse;
                } else {
                    ResponseEntity<CheckSmsEnabledResponseEnvelopDto> checkSmsEnabled = this.checkSmsEnabled(customer.getClient(), customer.getBankC());
                    if (checkSmsEnabled.getStatusCode() != HttpStatus.OK) {
                        Card card = this.cardService.generateTemplateCardFromCustomer(customer, (BalanceResponseEnvelopDto)balanceResponseEnvelopDtoResponse.getBody());
                        return ResponseEntity.status(HttpStatus.OK).body(card);
                    } else {
                        Pair<Result, Card> savedCard = this.cardService.saveCard(pan, ((BalanceResponseEnvelopDto)balanceResponseEnvelopDtoResponse.getBody()).getCard().getExpiry(), customer, (CheckSmsEnabledResponseEnvelopDto)checkSmsEnabled.getBody());
                        if (!((Result)savedCard.getFirst()).getCode().equalsIgnoreCase("OK")) {
                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(savedCard.getFirst());
                        } else {
                            Boolean exceeds = this.humoWsService.exceedsPinTry(pan);
                            Pair<Result, Card> updatedCard = this.cardService.updateBalance(pan, (BalanceResponseEnvelopDto)balanceResponseEnvelopDtoResponse.getBody(), exceeds);
                            if (!((Result)updatedCard.getFirst()).getCode().equalsIgnoreCase("OK")) {
                                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(updatedCard.getFirst());
                            } else {
                                Card card = (Card)updatedCard.getSecond();
                                card = this.clientService.save((ListCustomer)listCustomerResponse.getBody(), card);
                                return ResponseEntity.ok(card);
                            }
                        }
                    }
                }
            }
        } else {
            return ResponseEntity.badRequest().body((Object)null);
        }
    }

    public ResponseEntity<BalanceResponseEnvelopDto> getBalance(String card) throws TimeoutException {
        String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:IIACardServices\">\n   <soapenv:Header/>\n   <soapenv:Body>\n      <urn:getCardAccountsBalance>\n         <primaryAccountNumber>{CARD}</primaryAccountNumber>\n      </urn:getCardAccountsBalance>\n   </soapenv:Body>\n</soapenv:Envelope>\n";
        requestBody = requestBody.replaceAll("\\{CARD\\}", card);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.balanceUrl, HumoAction.GET_CARD_ACCOUNT_BALANCE, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<iiacs:getCardAccountsBalanceResponse>");
            Integer endIndex = rawXml.indexOf("</iiacs:getCardAccountsBalanceResponse>");
            rawXml = rawXml.substring(startIndex + 38, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();

            try {
                BalanceResponseEnvelopDto envelop = (BalanceResponseEnvelopDto)mapper.readValue(rawXml, BalanceResponseEnvelopDto.class);
                HumoError error = envelop.getCardStatusError();
                if (!error.getResult().getCode().equalsIgnoreCase("OK")) {
                    this.logger.error("Card status not valid");
                    this.logger.error("Error: " + error.getResult().toString());
                    this.logger.error("Card balance obj: " + envelop.toString());
                }

                return ResponseEntity.ok(envelop);
            } catch (IOException var10) {
                var10.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
    }

    public ResponseEntity<CheckSmsEnabledResponseEnvelopDto> checkSmsEnabled(String client, String bankCode) throws TimeoutException {
        String clientId = client + "-" + bankCode;
        String requestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:AccessGateway\">\n  <soapenv:Header />\n  <soapenv:Body>\n    <urn:export>\n      <cardholderID>{CLIENT_ID}</cardholderID>\n       <bankid>MB_STD</bankid>\n    </urn:export>\n  </soapenv:Body>\n</soapenv:Envelope>\n";
        requestBody = requestBody.replaceAll("\\{CLIENT_ID}", clientId);
        ResponseEntity<?> responseEntity = this.manager.requestHumoRest(this.exportAndImport, HumoAction.EXPORT, requestBody);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } else {
            String rawXml = responseEntity.getBody().toString();
            Integer startIndex = rawXml.lastIndexOf("<ag:exportResponse>");
            Integer endIndex = rawXml.indexOf("</ag:exportResponse>");
            rawXml = rawXml.substring(startIndex + 19, endIndex);
            rawXml = "<envelop>" + rawXml + "</envelop>";
            XmlMapper mapper = new XmlMapper();

            try {
                CheckSmsEnabledResponseEnvelopDto responseEnvelopDto = (CheckSmsEnabledResponseEnvelopDto)mapper.readValue(rawXml, CheckSmsEnabledResponseEnvelopDto.class);
                return ResponseEntity.ok(responseEnvelopDto);
            } catch (IOException var12) {
                var12.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
    }

    public UzCardCardsResult getBalanceByToken(String token) throws TimeoutException {
        Card result = new Card();
        result.setToken(token);
        result.setSms(false);
        String decPan = this.getPanByToken(token);
        ResponseEntity<BalanceResponseEnvelopDto> responseEntity = this.getBalance(decPan);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            result.setHolder(((BalanceResponseEnvelopDto)responseEntity.getBody()).getCard().getNameOnCard());
            result.setExpDate(((BalanceResponseEnvelopDto)responseEntity.getBody()).getCard().getExpiry());
            result.setBalance(((BalanceResponseEnvelopDto)responseEntity.getBody()).getBalance().getAvailableAmount());
            result.setSms(true);
        }

        return new UzCardCardsResult(result);
    }

    private String getPanByToken(String token) {
        Card card = (Card)this.cardService.getCardByToken(token).orElseThrow(() -> {
            return new CardNotFoundException(token);
        });
        String pan = card.getPan();
        if (pan != null && !pan.isEmpty() && pan.startsWith("9860")) {
            return CardUtil.decode(card.getEncPan());
        } else {
            throw new IncorrectPanException(pan);
        }
    }
}
