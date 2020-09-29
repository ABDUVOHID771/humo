package com.example.springhumo.controller;

import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.constant.PaymentType;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.CommonErrorResult;
import com.example.springhumo.model.dto.humo.request.CreatePaymentRequestDto;
import com.example.springhumo.service.api.HumoPayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoldController {
    private Logger logger = LogManager.getLogger(HoldController.class);
    private final HumoPayService humoPayService;

    public HoldController(HumoPayService humoPayService) {
        this.humoPayService = humoPayService;
    }

    @PostMapping(
            value = {"/hold"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> hold(@RequestBody CreatePaymentRequestDto requestDto) {
        this.logger.info("Hold: " + requestDto.toString());
        ResponseEntity responseEntity = null;

        try {
            responseEntity = this.humoPayService.createPayment(requestDto, PaymentType.HOLD);
            return responseEntity;
        } catch (TimeoutException var4) {
            this.logger.error(var4.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping(
            value = {"/hold-charge"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> holdCharge(@RequestBody HashMap<String, Object> params) {
        this.logger.info("Hold charge: " + params.toString());
        return this.humoPayService.holdCharge(params);
    }

    @PostMapping(
            value = {"/hold-dismiss"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> holdDismiss(@RequestBody HashMap<String, Object> params) {
        this.logger.info("Hold dismiss: " + params.toString());
        Integer paymentId = Integer.valueOf(params.getOrDefault("payment_id", "0").toString());
        this.logger.info("payment_id: " + paymentId);

        try {
            return this.humoPayService.holdDismiss(paymentId);
        } catch (TimeoutException var4) {
            this.logger.error(var4.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }
}
