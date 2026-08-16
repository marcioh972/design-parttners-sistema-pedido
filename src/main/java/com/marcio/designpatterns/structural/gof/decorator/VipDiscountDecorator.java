package com.marcio.designpatterns.structural.gof.decorator;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

/** Aplica 10% de desconto se o cliente for VIP. */
public class VipDiscountDecorator extends PriceCalculatorDecorator {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.10");

    public VipDiscountDecorator(PriceCalculator wrapped) {
        super(wrapped);
    }

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal base = wrapped.calculate(order);
        if (!order.getCustomer().vip()) {
            return base;
        }
        return base.subtract(base.multiply(DISCOUNT_RATE)).setScale(2, java.math.RoundingMode.HALF_UP);
    }
}
