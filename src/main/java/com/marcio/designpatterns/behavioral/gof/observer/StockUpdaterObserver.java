package com.marcio.designpatterns.behavioral.gof.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

public class StockUpdaterObserver implements OrderObserver {
    @Override
    public void onStatusChanged(Order order, OrderStatus previousStatus) {
        if (order.getStatus() == OrderStatus.CANCELADO) {
            System.out.println("[Estoque] devolvendo itens do pedido " + order.getId() + " ao estoque");
        }
    }
}
