package com.marcio.designpatterns.structural.gof.decorator;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

public interface PriceCalculator {
    BigDecimal calculate(Order order);
}
