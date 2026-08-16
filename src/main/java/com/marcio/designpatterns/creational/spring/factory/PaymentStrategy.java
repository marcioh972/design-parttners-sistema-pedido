package com.marcio.designpatterns.creational.spring.factory;

import java.math.BigDecimal;

public interface PaymentStrategy {
    String charge(BigDecimal amount);
}
