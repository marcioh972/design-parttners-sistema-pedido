package com.marcio.designpatterns.creational.gof.factory;

import java.math.BigDecimal;

public class BoletoPayment implements PaymentMethod {
    @Override
    public String charge(BigDecimal amount) {
        return "Boleto de R$ %s gerado, vencimento em 3 dias úteis".formatted(amount);
    }
}
