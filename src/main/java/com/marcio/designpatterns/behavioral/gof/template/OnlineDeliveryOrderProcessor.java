package com.marcio.designpatterns.behavioral.gof.template;

import com.marcio.designpatterns.domain.Order;

public class OnlineDeliveryOrderProcessor extends OrderProcessor {
    @Override
    protected void deliver(Order order) {
        System.out.println("[Frete] enviando pedido " + order.getId() + " via transportadora");
    }
}
