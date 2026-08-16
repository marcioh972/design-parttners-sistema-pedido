package com.marcio.designpatterns.creational.spring.factory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("pix")
public class PixPaymentStrategy implements PaymentStrategy {
    @Override
    public String charge(BigDecimal amount) {
        return "Cobrado R$ %s via Pix (instantâneo)".formatted(amount);
    }
}
