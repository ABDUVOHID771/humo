package com.example.springhumo.service.local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.example.springhumo.model.dto.humo.request.RevertRequestDto;
import com.example.springhumo.model.entity.Terminal;
import com.example.springhumo.model.entity.Transaction;
import com.example.springhumo.repository.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionManagementService {
    private static Logger logger = LogManager.getLogger(TransactionManagementService.class);
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TerminalService terminalService;

    public TransactionManagementService() {
    }

    public RevertRequestDto generateRevertObject(String humoTransactionId) {
        Optional<Transaction> transaction = this.transactionRepository.findByHumoPaymentId(humoTransactionId);
        if (!transaction.isPresent()) {
            return null;
        } else {
            Terminal terminal = this.terminalService.findById(((Transaction)transaction.get()).getTerminalId());
            RevertRequestDto revertRequestDto = new RevertRequestDto();
            revertRequestDto.setMerchantId(terminal.getMerchantId());
            revertRequestDto.setTerminalId(terminal.getTerminalId());
            revertRequestDto.setCenterId(((Transaction)transaction.get()).getCard().getBank().getCenterId());
            revertRequestDto.setPaymentId(((Transaction)transaction.get()).getHumoPaymentId());
            return revertRequestDto;
        }
    }

    public void addPaymentIdToTransaction(String coreId, String humoPaymentId) {
        coreId = coreId.substring(0, coreId.indexOf(95));
        logger.info("Updating payment_id: " + humoPaymentId + " transaction_id: " + coreId);
        Optional<Transaction> transaction = this.transactionRepository.findById(Long.valueOf(coreId));
        if (transaction.isPresent()) {
            ((Transaction)transaction.get()).setHumoPaymentId(humoPaymentId);
            this.transactionRepository.save(transaction.get());
        } else {
            logger.warn("could not find transaction by transaction_id: " + coreId);
        }

    }

    public List<Transaction> getUnsuccessfulTransactions(LocalDateTime start, LocalDateTime end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String startDate = formatter.format(start);
        String endDate = formatter.format(end);
        return this.transactionRepository.findUnsuccessfulTransactions(startDate, endDate);
    }

    public void saveAll(List<Transaction> transactions) {
        this.transactionRepository.saveAll(transactions);
    }

    public void updateStatusCode(String sessionId, String responseCode) {
        try {
            String transactionId = sessionId.split("_")[0];
            Transaction transaction = (Transaction)this.transactionRepository.findById(Long.valueOf(transactionId)).get();
            transaction.setResponseCode(responseCode);
            this.transactionRepository.save(transaction);
        } catch (Exception var5) {
            logger.error("Could not update response code for transaction: " + sessionId + "\nand responseCode: " + responseCode, var5);
        }

    }
}
