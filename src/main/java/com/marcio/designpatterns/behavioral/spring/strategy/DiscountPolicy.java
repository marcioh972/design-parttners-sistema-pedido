package com.marcio.designpatterns.behavioral.spring.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

public interface DiscountPolicy {
    boolean supports(Order order);
    BigDecimal applyDiscount(Order order, BigDecimal amount);
}
