package com.marcio.designpatterns.behavioral.gof.command;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

public class ConfirmOrderCommand implements OrderCommand {
    private final Order order;
    private OrderStatus previousStatus;

    public ConfirmOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        previousStatus = order.getStatus();
        order.setStatus(OrderStatus.PAGO);
        System.out.println("[Comando] pedido " + order.getId() + " confirmado");
    }

    @Override
    public void undo() {
        order.setStatus(previousStatus);
        System.out.println("[Comando] confirmação do pedido " + order.getId() + " desfeita");
    }
}
