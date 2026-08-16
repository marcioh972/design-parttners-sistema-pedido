package com.marcio.designpatterns.creational.spring.factory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("cartao")
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public String charge(BigDecimal amount) {
        return "Cobrado R$ %s no cartão de crédito".formatted(amount);
    }
}
