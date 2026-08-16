package com.marcio.designpatterns.creational.gof.factory;

import java.math.BigDecimal;

/** Produto abstrato criado pela factory. */
public interface PaymentMethod {
    String charge(BigDecimal amount);
}
