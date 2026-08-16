package com.marcio.designpatterns.behavioral.spring.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Observador concreto, lado Spring: qualquer bean pode "assinar" o
 * evento apenas anotando um método com @EventListener -- sem implementar
 * nenhuma interface e sem ser registrado manualmente em lugar nenhum.
 */
@Component
public class EmailNotifierListener {

    @EventListener
    public void onOrderStatusChanged(OrderStatusChangedEvent event) {
        System.out.printf("[E-mail] %s: pedido %s mudou de %s para %s%n",
                event.getOrder().getCustomer().email(),
                event.getOrder().getId(),
                event.getPreviousStatus(),
                event.getOrder().getStatus());
    }
}
