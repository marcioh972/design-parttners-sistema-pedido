package com.marcio.designpatterns.behavioral.gof.chain;

public class OrderValidationException extends RuntimeException {
    public OrderValidationException(String message) {
        super(message);
    }
}
