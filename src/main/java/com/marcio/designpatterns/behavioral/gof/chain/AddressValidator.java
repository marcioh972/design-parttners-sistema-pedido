package com.marcio.designpatterns.behavioral.gof.chain;

import com.marcio.designpatterns.domain.Order;

public class AddressValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.getCustomer().address() == null) {
            throw new OrderValidationException("Cliente sem endereço de entrega cadastrado");
        }
        System.out.println("[Validação] endereço OK para pedido " + order.getId());
    }
}
