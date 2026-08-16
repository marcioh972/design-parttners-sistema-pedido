package com.marcio.designpatterns.structural.gof.facade;

import com.marcio.designpatterns.domain.Order;

public class ShippingSystem {
    public String schedule(Order order) {
        System.out.println("[Frete] agendando envio do pedido " + order.getId());
        return "BR" + System.nanoTime() % 1_000_000 + "9SP";
    }
}
