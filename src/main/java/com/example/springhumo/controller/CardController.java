package com.example.springhumo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.model.Result;
import com.example.springhumo.model.dto.CommonErrorResult;
import com.example.springhumo.model.dto.uzCard.*;
import com.example.springhumo.service.api.HumoCardService;
import com.example.springhumo.service.api.HumoWsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/cards"})
@RestController
public class CardController {
    private Logger logger = LogManager.getLogger(CardController.class);
    private final HumoCardService cardService;
    private final HumoWsService humoWsService;

    public CardController(HumoCardService cardService, HumoWsService humoWsService) {
        this.cardService = cardService;
        this.humoWsService = humoWsService;
    }

    @PostMapping({"/new"})
    public ResponseEntity<?> cardsNew(@RequestBody UzCardCardsRequestDto<CardsNewParam> requestDto) {
        this.logger.info("/cards/new");
        this.logger.info("Request body: " + requestDto.toString());

        try {
            ResponseEntity<?> responseEntity = this.cardService.cardInfo(requestDto);
            this.logger.info("Response code: " + responseEntity.getStatusCode().toString());
            this.logger.info("Response body: " + responseEntity.getBody().toString());
            return responseEntity;
        } catch (Exception var3) {
            this.logger.error(var3.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping({"/get"})
    public ResponseEntity<?> cardsGet(@RequestBody UzCardCardsRequestDto<CardsGetParam> requestDto) {
        this.logger.info("/cards/get");
        this.logger.info("Request body: " + requestDto.toString());

        try {
            ResponseEntity<?> responseEntity = this.cardService.byToken(requestDto);
            this.logger.info("Response code: " + responseEntity.getStatusCode().toString());
            this.logger.info("Response body: " + responseEntity.getBody().toString());
            return responseEntity;
        } catch (Exception var3) {
            this.logger.error(var3.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }

    @PostMapping({"/balance-only"})
    public ResponseEntity<?> getBalance(@RequestBody UzCardCardsRequestDto<CardsGetParam> requestDto) {
        if (requestDto.getParams() != null && ((CardsGetParam)requestDto.getParams()).getIds() != null && ((CardsGetParam)requestDto.getParams()).getIds().length != 0) {
            List<UzCardCardsResult> resultList = new ArrayList();
            String[] var3 = ((CardsGetParam)requestDto.getParams()).getIds();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String token = var3[var5];

                try {
                    resultList.add(this.cardService.getBalanceByToken(token));
                } catch (Exception var8) {
                    this.logger.error(var8.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
                }
            }

            UzCardCardsResponseDto result = new UzCardCardsResponseDto(resultList, requestDto.getJsonrpc(), requestDto.getId());
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body("Card token is not provided");
        }
    }

    @GetMapping({"/pin-flag"})
    public ResponseEntity<?> checkPinFlag(@RequestParam String pan) {
        try {
            return ResponseEntity.ok(this.humoWsService.exceedsPinTry(pan));
        } catch (TimeoutException var3) {
            this.logger.error(var3.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonErrorResult(new Result(ApiResults.ERR_094)));
        }
    }
}

