package com.marcio.designpatterns.behavioral.gof.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(Order order, BigDecimal amount);
}
