package com.example.springhumo.config;

import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTimeoutConfig {
    private final int TIMEOUT;

    public RestTemplateTimeoutConfig() {
        this.TIMEOUT = (int) TimeUnit.SECONDS.toMillis(10L);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(this.getRequestFactoryAdvanced());
    }

    private ClientHttpRequestFactory getRequestFactoryAdvanced() {
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
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        }

        try {
            sslContext.init((KeyManager[]) null, trustAllCerts, new SecureRandom());
        } catch (KeyManagementException var6) {
            var6.printStackTrace();
        }

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        RequestConfig config = RequestConfig.custom().setSocketTimeout(this.TIMEOUT).setConnectTimeout(this.TIMEOUT).setConnectionRequestTimeout(this.TIMEOUT).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).setSSLSocketFactory(csf).build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
}
