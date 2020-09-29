package com.example.springhumo.exception;

public class IncorrectPanException extends RuntimeException {
    public IncorrectPanException(String pan) {
        super("Provided card PAN is incorrect");
    }
}
