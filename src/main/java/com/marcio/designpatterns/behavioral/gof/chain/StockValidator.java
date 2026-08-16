package com.marcio.designpatterns.behavioral.gof.chain;

import com.marcio.designpatterns.domain.Order;

public class StockValidator extends OrderValidator {
    @Override
    protected void check(Order order) {
        if (order.getItems().isEmpty()) {
            throw new OrderValidationException("Pedido sem itens em estoque");
        }
        System.out.println("[Validação] estoque OK para pedido " + order.getId());
    }
}
