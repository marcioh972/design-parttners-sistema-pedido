package com.marcio.designpatterns.structural.spring.adapter;

import java.math.BigDecimal;

public interface PaymentGatewayPort {
    String charge(BigDecimal amountInReais);
}
