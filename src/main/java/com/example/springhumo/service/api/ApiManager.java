package com.example.springhumo.service.api;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import com.example.springhumo.constant.ApiResults;
import com.example.springhumo.constant.HumoAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiManager {
    private Logger logger = LogManager.getLogger(ApiManager.class);
    @Value("${humo.username}")
    private String username;
    @Value("${humo.password}")
    private String password;
    @Autowired
    private NotifierService notifierService;

    public ApiManager() {
    }

    public ResponseEntity<?> requestHumoRest(String url, HumoAction action, String body) {
        this.logger.info("Requested Url: " + url);
        this.logger.info("Request body: " + body);
        TrustManager[] trustAllCerts = new TrustManager[]{new X509ExtendedTrustManager() {
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {
            }

            public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {
            }
        }};
        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException var14) {
            var14.printStackTrace();
        }

        try {
            sslContext.init((KeyManager[])null, trustAllCerts, new SecureRandom());
        } catch (KeyManagementException var13) {
            var13.printStackTrace();
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.add("SOAPAction", action.getAction());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(this.username, this.password));
        restTemplate.setErrorHandler(new ApiManager.RestErrorHandler());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        try {
            ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class, new Object[0]);
            this.logger.info("Response status: " + response.getStatusCode());
            this.logger.info("Response body: " + response.getBody());
            return response;
        } catch (ResourceAccessException var12) {
            var12.printStackTrace();
            this.logger.error(var12.getMessage());
            String methodName = (new Object() {
            }).getClass().getEnclosingMethod().getName();
            String className = this.getClass().getCanonicalName();
            this.notifierService.notifyError(className + "." + methodName, body, var12.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ApiResults.ERR_041);
        }
    }

    static class RestErrorHandler implements ResponseErrorHandler {
        RestErrorHandler() {
        }

        public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
            return clientHttpResponse.getStatusCode().series() == Series.CLIENT_ERROR || clientHttpResponse.getStatusCode().series() == Series.SERVER_ERROR;
        }

        public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            Logger logger = LogManager.getLogger(ApiManager.class);
            logger.error("Response error: {} {}", clientHttpResponse.getStatusCode(), clientHttpResponse.getStatusText());
        }
    }
}
