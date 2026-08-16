package com.marcio.designpatterns.structural.gof.adapter;

import java.math.BigDecimal;

/** Interface que o RESTANTE do nosso sistema espera usar. */
public interface PaymentGateway {
    String charge(BigDecimal amountInReais);
}
