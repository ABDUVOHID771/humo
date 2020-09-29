package com.example.springhumo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientException;

public class CustomClientException extends WebClientException {
    private final HttpStatus status;

    public CustomClientException(HttpStatus status) {
        super(status.getReasonPhrase());
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
