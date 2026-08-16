package com.marcio.designpatterns.behavioral.gof.template;

import com.marcio.designpatterns.domain.Order;

public class StorePickupOrderProcessor extends OrderProcessor {
    @Override
    protected void deliver(Order order) {
        System.out.println("[Loja] pedido " + order.getId() + " disponível para retirada");
    }
}
