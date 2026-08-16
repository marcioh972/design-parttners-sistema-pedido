package com.marcio.designpatterns.behavioral.gof.command;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

public class CancelOrderCommand implements OrderCommand {
    private final Order order;
    private OrderStatus previousStatus;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        previousStatus = order.getStatus();
        order.setStatus(OrderStatus.CANCELADO);
        System.out.println("[Comando] pedido " + order.getId() + " cancelado");
    }

    @Override
    public void undo() {
        order.setStatus(previousStatus);
        System.out.println("[Comando] cancelamento do pedido " + order.getId() + " desfeito");
    }
}
