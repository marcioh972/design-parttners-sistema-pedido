package com.marcio.designpatterns.structural.gof.decorator;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

/** Componente concreto: apenas soma os itens do pedido. */
public class BasePriceCalculator implements PriceCalculator {
    @Override
    public BigDecimal calculate(Order order) {
        return order.subtotal();
    }
}
