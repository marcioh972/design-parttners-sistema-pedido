package com.marcio.designpatterns.behavioral.gof.strategy;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

/**
 * STRATEGY clássico (GoF).
 *
 * O algoritmo de desconto varia (VIP, compra em volume, sem desconto...)
 * e queremos trocar esse algoritmo em tempo de execução sem usar um
 * emaranhado de if/else. O Contexto (PricingContext) recebe QUALQUER
 * DiscountStrategy no construtor e delega o cálculo para ela.
 */
public class PricingContext {

    private final DiscountStrategy strategy;

    public PricingContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal calculateFinalPrice(Order order) {
        return strategy.applyDiscount(order, order.subtotal());
    }
}
