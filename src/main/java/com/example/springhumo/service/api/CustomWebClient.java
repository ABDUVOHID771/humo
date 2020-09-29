package com.example.springhumo.service.api;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import javax.net.ssl.SSLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Component
public class CustomWebClient {
    @Value("${humo.username}")
    private String username;
    @Value("${humo.password}")
    private String password;

    public CustomWebClient() {
    }

    public WebClient createClient() {
        ReactorClientHttpConnector connector = null;

        try {
            SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            HttpClient httpClient = HttpClient.create().secure((sslContextSpec) -> {
                sslContextSpec.sslContext(sslContext);
            });
            connector = new ReactorClientHttpConnector(httpClient);
        } catch (SSLException var4) {
            var4.printStackTrace();
        }

        WebClient client3 = WebClient.builder().defaultHeader("Content-Type", new String[]{MediaType.APPLICATION_XML.toString()}).filter(ExchangeFilterFunctions.basicAuthentication(this.username, this.password)).clientConnector(connector).build();
        return client3;
    }
}
