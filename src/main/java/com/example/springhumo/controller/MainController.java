package com.example.springhumo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.constant.PaymentType;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.CardInfoDto;
import com.example.springhumo.model.dto.CommonErrorResult;
import com.example.springhumo.model.dto.CreateAndConfirmRequestDto;
import com.example.springhumo.model.dto.humo.request.ConfirmPaymentRequestDto;
import com.example.springhumo.model.dto.humo.request.CreatePaymentRequestDto;
import com.example.springhumo.scheduler.ReconcileScheduler;
import com.example.springhumo.service.api.HumoCardService;
import com.example.springhumo.service.api.HumoPayService;
import com.example.springhumo.service.api.HumoWsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {
    private Logger logger = LogManager.getLogger(MainController.class);
    @Autowired
    private HumoPayService humoPayService;
    @Autowired
    private HumoCardService cardService;
    @Autowired
    private HumoWsService humoWsService;
    @Autowired
    private ReconcileScheduler scheduler;

    public MainController() {
    }

    @GetMapping(
            produces = {"application/json"}
    )
    public ResponseEntity<?> info(@RequestParam String card) {
        this.logger.info("Info: pan -> " + card);
        ResponseEntity responseEntity = null;

        try {
            responseEntity = this.cardService.cardInfo(card);
        } catch (TimeoutException var4) {
            var4.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            CardInfoDto result = (CardInfoDto)responseEntity.getBody();
            return ResponseEntity.ok(result.getCard());
        } else {
            return responseEntity;
        }
    }

    @GetMapping(
            value = {"/by-token"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> byToken(@RequestParam String token) {
        this.logger.info("Info: token -> " + token);
        ResponseEntity responseEntity = null;

        try {
            responseEntity = this.cardService.byToken(token);
        } catch (TimeoutException var4) {
            var4.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            CardInfoDto result = (CardInfoDto)responseEntity.getBody();
            return ResponseEntity.ok(result.getCard());
        } else {
            return responseEntity;
        }
    }

    @GetMapping(
            value = {"/p2p-info"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> p2pInfo(@RequestParam String card) {
        this.logger.info("Info: pan -> " + card);

        try {
            return this.cardService.p2pInfo(card);
        } catch (TimeoutException var3) {
            var3.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping(
            value = {"/create"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> create(@RequestBody CreatePaymentRequestDto requestDto) {
        this.logger.info("Create: " + requestDto.toString());

        try {
            return this.humoPayService.createPayment(requestDto, PaymentType.PAY);
        } catch (TimeoutException var3) {
            var3.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping(
            value = {"/confirm"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> confirm(@RequestBody ConfirmPaymentRequestDto requestDto) {
        this.logger.info("Confirm: " + requestDto.toString());
        return this.humoPayService.confirmPayment(requestDto);
    }

    @PostMapping(
            value = {"/create-confirm"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> createAndConfirm(@RequestBody CreateAndConfirmRequestDto createAndConfirmRequestDto) {
        this.logger.info("Create and Confirm: " + createAndConfirmRequestDto.toString());
        if (createAndConfirmRequestDto.getMerchantId() != null && createAndConfirmRequestDto.getTerminalId() != null) {
            ResponseEntity responseEntity = null;

            try {
                responseEntity = this.humoPayService.createAndConfirm(createAndConfirmRequestDto, PaymentType.PAY);
            } catch (TimeoutException var4) {
                var4.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
            }

            this.logger.info("Response code: " + responseEntity.getStatusCode());
            this.logger.info("Response body: " + responseEntity.getBody());
            return responseEntity;
        } else {
            return ResponseEntity.badRequest().body("");
        }
    }

    @GetMapping(
            value = {"/history"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> history(@RequestParam String token, @RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start, @RequestParam @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {
        try {
            return this.humoWsService.history(token, start, end);
        } catch (TimeoutException var5) {
            var5.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping(
            value = {"/revert"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> revert(@RequestBody HashMap<String, String> param) {
        String humoTranId = (String)param.getOrDefault("humo_tran_id", "0");
        if (humoTranId.equalsIgnoreCase("0")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        } else {
            try {
                return this.humoPayService.revert(humoTranId);
            } catch (TimeoutException var4) {
                var4.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
            }
        }
    }

    @GetMapping({"/check"})
    public ResponseEntity<?> check(@RequestParam(value = "payment_id",required = false,defaultValue = "") String paymentId, @RequestParam(value = "ext_id",required = false,defaultValue = "") String externalId) {
        if (paymentId.isEmpty() && externalId.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                return this.humoPayService.checkTransaction(paymentId, externalId);
            } catch (TimeoutException var4) {
                var4.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
            }
        }
    }

    @GetMapping({"/reconcile"})
    public ResponseEntity<?> check(@RequestParam(value = "minus-days",defaultValue = "1") Integer minusDays) {
        if (minusDays == null) {
            minusDays = 1;
        }

        try {
            LocalDate yesterday = LocalDate.now();
            yesterday = yesterday.minusDays((long)minusDays);
            LocalDateTime start = LocalDateTime.of(yesterday, LocalTime.MIN);
            LocalDateTime end = LocalDateTime.of(yesterday, LocalTime.MAX);
            this.scheduler.reconcileUnsuccessfulPayments(start, end);
            return ResponseEntity.ok("");
        } catch (Exception var5) {
            this.logger.error("Unexpected error during reconciliation", var5);
            var5.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(var5.getMessage());
        }
    }
}
