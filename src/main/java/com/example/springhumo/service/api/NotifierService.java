package com.example.springhumo.service.api;

import java.time.LocalDateTime;

import com.example.springhumo.util.CardUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class NotifierService {
    private static Logger logger = LogManager.getLogger(NotifierService.class);
    @Value("${api.notifier}")
    private String notifierUrl;
    @Autowired
    private Environment env;

    public NotifierService() {
    }

    @Async
    public void notifyError(String moduleName, String body, String exception) {
        String profile = "development";
        if (this.env.getActiveProfiles() != null && this.env.getActiveProfiles().length > 0) {
            profile = this.env.getActiveProfiles()[0];
        }

        String msg = "Модуль: " + moduleName + " \n\n(#" + profile + ") \n\nВремя: " + LocalDateTime.now() + " \n\n " + CardUtil.maskLogString(body) + " \n\nException: " + exception;
        logger.info("Message: " + msg);
    }

    public ResponseEntity<String> postRequest(String url, String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(body, headers);
        ResponseEntity<String> response = (new RestTemplate()).postForEntity(url, request, String.class, new Object[0]);
        return response;
    }
}
