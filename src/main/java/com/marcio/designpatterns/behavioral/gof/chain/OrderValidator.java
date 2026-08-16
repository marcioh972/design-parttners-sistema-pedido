package com.marcio.designpatterns.behavioral.gof.chain;

import com.marcio.designpatterns.domain.Order;

/**
 * CHAIN OF RESPONSIBILITY clássico (GoF).
 *
 * Cada validador sabe fazer UMA verificação e conhece o "próximo" elo
 * da corrente. Se passar na própria checagem, repassa a chamada adiante;
 * se falhar, lança exceção e interrompe a cadeia. O código cliente só
 * conhece o primeiro elo -- não sabe (nem precisa saber) quantos
 * validadores existem ou em que ordem rodam internamente.
 */
public abstract class OrderValidator {

    private OrderValidator next;

    public OrderValidator linkWith(OrderValidator next) {
        this.next = next;
        return next;
    }

    public final void validate(Order order) {
        check(order);
        if (next != null) {
            next.validate(order);
        }
    }

    protected abstract void check(Order order);
}
