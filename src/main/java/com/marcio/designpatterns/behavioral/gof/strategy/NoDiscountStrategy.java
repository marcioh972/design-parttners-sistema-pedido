package com.marcio.designpatterns.behavioral.gof.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal applyDiscount(Order order, BigDecimal amount) {
        return amount;
    }
}
