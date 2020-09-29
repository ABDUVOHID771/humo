package com.example.springhumo.exception;


public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String cardId) {
        super("Card with id " + cardId + " is not found");
    }
}
