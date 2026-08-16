package com.marcio.designpatterns.creational.spring.factory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("boleto")
public class BoletoPaymentStrategy implements PaymentStrategy {
    @Override
    public String charge(BigDecimal amount) {
        return "Boleto de R$ %s gerado, vencimento em 3 dias úteis".formatted(amount);
    }
}
