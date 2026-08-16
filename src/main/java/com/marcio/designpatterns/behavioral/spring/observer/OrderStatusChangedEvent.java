package com.marcio.designpatterns.behavioral.spring.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;
import org.springframework.context.ApplicationEvent;

/** Evento de domínio publicado sempre que o status de um pedido muda. */
public class OrderStatusChangedEvent extends ApplicationEvent {

    private final Order order;
    private final OrderStatus previousStatus;

    public OrderStatusChangedEvent(Object source, Order order, OrderStatus previousStatus) {
        super(source);
        this.order = order;
        this.previousStatus = previousStatus;
    }

    public Order getOrder() { return order; }
    public OrderStatus getPreviousStatus() { return previousStatus; }
}
