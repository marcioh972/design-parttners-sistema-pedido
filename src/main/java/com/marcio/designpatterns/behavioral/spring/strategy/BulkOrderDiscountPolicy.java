package com.marcio.designpatterns.behavioral.spring.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Order(2)
public class BulkOrderDiscountPolicy implements DiscountPolicy {
    private static final BigDecimal RATE = new BigDecimal("0.05");

    @Override
    public boolean supports(com.marcio.designpatterns.domain.Order order) {
        int totalItems = order.getItems().stream().mapToInt(i -> i.quantity()).sum();
        return totalItems >= 10;
    }

    @Override
    public BigDecimal applyDiscount(com.marcio.designpatterns.domain.Order order, BigDecimal amount) {
        return amount.subtract(amount.multiply(RATE)).setScale(2, RoundingMode.HALF_UP);
    }
}
