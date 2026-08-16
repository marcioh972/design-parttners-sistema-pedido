package com.marcio.designpatterns.behavioral.spring.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * OBSERVER "à la Spring" -- lado do "assunto" (Subject).
 *
 * Em vez de manter uma List<OrderObserver> manualmente, publicamos um
 * evento no ApplicationEventPublisher do próprio Spring. O container
 * já é, por baixo dos panos, um barramento de eventos observer/subject.
 */
@Component
public class OrderStatusPublisher {

    private final ApplicationEventPublisher publisher;

    public OrderStatusPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void changeStatus(Order order, OrderStatus newStatus) {
        OrderStatus previous = order.getStatus();
        order.setStatus(newStatus);
        publisher.publishEvent(new OrderStatusChangedEvent(this, order, previous));
    }
}
