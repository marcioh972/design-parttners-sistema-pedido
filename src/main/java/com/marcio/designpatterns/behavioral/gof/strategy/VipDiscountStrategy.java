package com.marcio.designpatterns.behavioral.gof.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VipDiscountStrategy implements DiscountStrategy {
    private static final BigDecimal RATE = new BigDecimal("0.10");

    @Override
    public BigDecimal applyDiscount(Order order, BigDecimal amount) {
        return amount.subtract(amount.multiply(RATE)).setScale(2, RoundingMode.HALF_UP);
    }
}
