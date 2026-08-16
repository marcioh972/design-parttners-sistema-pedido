package com.marcio.designpatterns.creational.gof.factory;

import java.math.BigDecimal;

public class PixPayment implements PaymentMethod {
    @Override
    public String charge(BigDecimal amount) {
        return "Cobrado R$ %s via Pix (instantâneo)".formatted(amount);
    }
}
