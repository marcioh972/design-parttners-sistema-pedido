package com.marcio.designpatterns.creational.gof.factory;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String charge(BigDecimal amount) {
        return "Cobrado R$ %s no cartão de crédito".formatted(amount);
    }
}
