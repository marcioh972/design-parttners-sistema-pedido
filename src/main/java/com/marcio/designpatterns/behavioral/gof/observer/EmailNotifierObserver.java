package com.marcio.designpatterns.behavioral.gof.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

public class EmailNotifierObserver implements OrderObserver {
    @Override
    public void onStatusChanged(Order order, OrderStatus previousStatus) {
        System.out.printf("[E-mail] %s: pedido %s mudou de %s para %s%n",
                order.getCustomer().email(), order.getId(), previousStatus, order.getStatus());
    }
}
