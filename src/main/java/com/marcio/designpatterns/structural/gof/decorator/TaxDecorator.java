package com.marcio.designpatterns.structural.gof.decorator;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

/** Adiciona 8% de imposto sobre o preço calculado até aqui. */
public class TaxDecorator extends PriceCalculatorDecorator {

    private static final BigDecimal TAX_RATE = new BigDecimal("0.08");

    public TaxDecorator(PriceCalculator wrapped) {
        super(wrapped);
    }

    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal base = wrapped.calculate(order);
        return base.add(base.multiply(TAX_RATE)).setScale(2, java.math.RoundingMode.HALF_UP);
    }
}
