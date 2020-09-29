package com.example.springhumo.service.api;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import com.example.springhumo.constant.HumoAction;
import com.example.springhumo.util.ApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

@Service
public class WebClientService {
    private Logger logger = LogManager.getLogger(WebClientService.class);
    @Autowired
    private CustomWebClient webClient;
    @Autowired
    private NotifierService notifierService;

    public WebClientService() {
    }

    public ResponseEntity<String> requestHumoRest(String url, HumoAction action, String body) throws TimeoutException {
        this.logger.info("Requested Url: " + url);
        this.logger.info("Request body: " + body);

        String methodName;
        try {
            ResponseEntity<String> response = (ResponseEntity)((RequestBodySpec)((RequestBodySpec)this.webClient.createClient().post().uri(URI.create(url))).header("SOAPAction", new String[]{action.getAction()})).body(BodyInserters.fromObject(body)).exchange().flatMap((clientResponse) -> {
                return clientResponse.toEntity(String.class);
            }).timeout(Duration.ofSeconds(30L)).block();
            if (response.getStatusCode() == HttpStatus.OK) {
                this.logger.info("Response status: " + response.getStatusCode());
                this.logger.info("Response body: " + (String)response.getBody());
            } else {
                Boolean sendNotification = ApiUtil.canSendNotification((String)response.getBody(), action);
                if (sendNotification) {
                    methodName = (new Object() {
                    }).getClass().getEnclosingMethod().getName();
                    String className = this.getClass().getCanonicalName();
                    this.notifierService.notifyError(className + "." + methodName, body, (String)response.getBody());
                    this.logger.error("Response status: " + response.getStatusCode());
                    this.logger.error("Response body: " + (String)response.getBody());
                }
            }

            return response;
        } catch (Exception var8) {
            methodName = (new Object() {
            }).getClass().getEnclosingMethod().getName();
            methodName = this.getClass().getCanonicalName();
            this.logger.error(var8.getMessage());
            this.notifierService.notifyError(methodName + "." + methodName, body, var8.getMessage());
            throw new TimeoutException();
        }
    }
}

