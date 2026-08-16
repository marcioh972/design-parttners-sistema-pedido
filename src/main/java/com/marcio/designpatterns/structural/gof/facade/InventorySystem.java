package com.marcio.designpatterns.structural.gof.facade;

import com.marcio.designpatterns.domain.Order;

public class InventorySystem {
    public void reserve(Order order) {
        System.out.println("[Estoque] reservando itens do pedido " + order.getId());
    }
}
