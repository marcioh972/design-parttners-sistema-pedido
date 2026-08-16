package com.marcio.designpatterns.behavioral.spring.strategy;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Order(1)
public class VipDiscountPolicy implements DiscountPolicy {
    private static final BigDecimal RATE = new BigDecimal("0.10");

    @Override
    public boolean supports(com.marcio.designpatterns.domain.Order order) {
        return order.getCustomer().vip();
    }

    @Override
    public BigDecimal applyDiscount(com.marcio.designpatterns.domain.Order order, BigDecimal amount) {
        return amount.subtract(amount.multiply(RATE)).setScale(2, RoundingMode.HALF_UP);
    }
}
