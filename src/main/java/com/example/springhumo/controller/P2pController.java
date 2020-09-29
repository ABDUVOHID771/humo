package com.example.springhumo.controller;

import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.CommonErrorResult;
import com.example.springhumo.model.dto.humo.request.P2pApplyRequestDto;
import com.example.springhumo.model.dto.humo.request.P2pCreateRequestDto;
import com.example.springhumo.service.api.HumoP2pService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/p2p"})
public class P2pController {
    private Logger logger = LogManager.getLogger(P2pController.class);
    @Autowired
    private HumoP2pService p2pService;

    public P2pController() {
    }

    @PostMapping({"/create"})
    public ResponseEntity<?> create(@RequestBody P2pCreateRequestDto requestDto) {
        this.logger.info("/create");
        this.logger.info("Request body: " + requestDto.toString());

        try {
            ResponseEntity<?> responseEntity = this.p2pService.create(requestDto);
            this.logger.info("Response code: " + responseEntity.getStatusCode().toString());
            this.logger.info("Response body: " + responseEntity.getBody().toString());
            return responseEntity;
        } catch (TimeoutException var3) {
            this.logger.error(var3.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping({"/apply"})
    public ResponseEntity<?> apply(@RequestBody P2pApplyRequestDto requestDto) {
        this.logger.info("/apply");
        this.logger.info("Request body: " + requestDto.toString());
        ResponseEntity<?> responseEntity = this.p2pService.apply(requestDto);
        this.logger.info("Response code: " + responseEntity.getStatusCode().toString());
        this.logger.info("Response body: " + responseEntity.getBody().toString());
        return responseEntity;
    }

    @PostMapping({"/create-apply"})
    public ResponseEntity<?> createAndApply(@RequestBody P2pCreateRequestDto requestDto) {
        this.logger.info("/create-apply");
        this.logger.info("Request body: " + requestDto.toString());

        try {
            ResponseEntity<?> responseEntity = this.p2pService.createAndApply(requestDto);
            this.logger.info("Response code: " + responseEntity.getStatusCode().toString());
            this.logger.info("Response body: " + responseEntity.getBody().toString());
            return responseEntity;
        } catch (TimeoutException var3) {
            this.logger.error(var3.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }
}

