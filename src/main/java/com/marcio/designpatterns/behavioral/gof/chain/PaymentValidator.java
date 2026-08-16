package com.marcio.designpatterns.behavioral.gof.chain;

import com.marcio.designpatterns.domain.Order;

import java.math.BigDecimal;

public class PaymentValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.subtotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new OrderValidationException("Valor do pedido inválido");
        }
        System.out.println("[Validação] valores OK para pedido " + order.getId());
    }
}
