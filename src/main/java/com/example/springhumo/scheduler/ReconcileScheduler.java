package com.example.springhumo.scheduler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.PaymentStatus;
import com.example.springhumo.model.dto.humo.response.CheckPaymentResponseEnvelopDto;
import com.example.springhumo.model.dto.humo.response.PaymentResponseEnvelopDto;
import com.example.springhumo.model.entity.Terminal;
import com.example.springhumo.model.entity.Transaction;
import com.example.springhumo.service.api.HumoPayService;
import com.example.springhumo.service.local.TerminalService;
import com.example.springhumo.service.local.TransactionManagementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReconcileScheduler {
    private Logger logger = LogManager.getLogger(ReconcileScheduler.class);
    @Autowired
    private HumoPayService payService;
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private TransactionManagementService transactionService;
    @Autowired
    private HumoPayService humoPayService;

    public ReconcileScheduler() {
    }

    @Scheduled(
            cron = "00 01 08,18 * * *"
    )
    public void reconcile() throws TimeoutException {
        this.logger.info("Reconciliation started: " + LocalDateTime.now());
        List<Terminal> terminals = this.terminalService.getTerminalsForReconciliation();
        Iterator var2 = terminals.iterator();

        while(var2.hasNext()) {
            Terminal terminal = (Terminal)var2.next();
            this.logger.info("Terminal: " + terminal.toString());
            ResponseEntity<?> createReconcile = this.payService.reconcileCreate(terminal.getTerminalId());
            if (createReconcile.getStatusCode() != HttpStatus.OK) {
                this.logger.error("Reconciliation create failed for terminal: " + terminal.toString());
            } else {
                PaymentResponseEnvelopDto recocileCreateResponseEnvelopDto = (PaymentResponseEnvelopDto)createReconcile.getBody();
                ResponseEntity<?> confirmReconcile = this.payService.reconcileConfirm(recocileCreateResponseEnvelopDto.getPaymentId(), terminal.getTerminalId());
                if (confirmReconcile.getStatusCode() != HttpStatus.OK) {
                    this.logger.error("Reconciliation confirm failed for payment id: " + recocileCreateResponseEnvelopDto.getPaymentId());
                } else {
                    this.logger.info("Terminal reconciliation passed successfully: " + terminal.toString());
                }
            }
        }

    }

    @Scheduled(
            cron = "0 0/30 00 * * *"
    )
    public void reconcileUnsuccessfulPayments() {
        LocalDate yesterday = LocalDate.now();
        yesterday = yesterday.minusDays(1L);
        LocalDateTime start = LocalDateTime.of(yesterday, LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(yesterday, LocalTime.MAX);
        this.reconcileUnsuccessfulPayments(start, end);
    }

    public void reconcileUnsuccessfulPayments(LocalDateTime start, LocalDateTime end) {
        this.logger.info("Starting unsuccessful payments reconciliation for period: from " + start.toString() + " to " + end.toString());
        List<Transaction> unsuccessfulTransactions = this.transactionService.getUnsuccessfulTransactions(start, end);
        Iterator var4 = unsuccessfulTransactions.iterator();

        while(var4.hasNext()) {
            Transaction unsuccessfulTransaction = (Transaction)var4.next();
            unsuccessfulTransaction.setRecoResult(1);

            try {
                ResponseEntity<CheckPaymentResponseEnvelopDto> responseEntity = this.humoPayService.checkTransaction("", unsuccessfulTransaction.getId().toString());
                if (responseEntity.getStatusCode().is2xxSuccessful()) {
                    CheckPaymentResponseEnvelopDto payment = (CheckPaymentResponseEnvelopDto)responseEntity.getBody();
                    if (payment.getStatus() == PaymentStatus.finished) {
                        this.logger.warn("Payment status conflict");
                        this.logger.warn("Transaction: " + unsuccessfulTransaction.toString());
                        this.logger.warn("Payment: " + payment.toString());
                        this.logger.warn("Reverting payment: " + payment.getPaymentId());
                        ResponseEntity<?> revertResp = this.humoPayService.revert(unsuccessfulTransaction.getId().toString());
                        if (revertResp.getStatusCode().is2xxSuccessful()) {
                            this.logger.warn("Successfully reverted");
                            unsuccessfulTransaction.setRecoResult(2);
                        } else {
                            this.logger.error("Failed to revert");
                        }
                    }
                } else {
                    this.logger.warn("Could not retrieve payment by transaction: " + unsuccessfulTransaction.getId());
                }
            } catch (TimeoutException var9) {
                this.logger.error(var9.getMessage(), var9);
            }
        }

        this.transactionService.saveAll(unsuccessfulTransactions);
    }
}
