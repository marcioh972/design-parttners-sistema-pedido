package com.marcio.designpatterns.behavioral.gof.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BulkOrderDiscountStrategy implements DiscountStrategy {
    private static final BigDecimal RATE = new BigDecimal("0.05");

    @Override
    public BigDecimal applyDiscount(Order order, BigDecimal amount) {
        int totalItems = order.getItems().stream().mapToInt(i -> i.quantity()).sum();
        if (totalItems < 10) {
            return amount;
        }
        return amount.subtract(amount.multiply(RATE)).setScale(2, RoundingMode.HALF_UP);
    }
}
