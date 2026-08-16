package com.marcio.designpatterns.behavioral.spring.observer;

import com.marcio.designpatterns.domain.OrderStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StockUpdaterListener {

    @EventListener
    public void onOrderStatusChanged(OrderStatusChangedEvent event) {
        if (event.getOrder().getStatus() == OrderStatus.CANCELADO) {
            System.out.println("[Estoque] devolvendo itens do pedido "
                    + event.getOrder().getId() + " ao estoque");
        }
    }
}
