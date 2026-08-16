package com.marcio.designpatterns.behavioral.spring.template;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Service;

@Service("retirada")
public class StorePickupDeliveryService extends OrderDeliveryProcessor {
    @Override
    protected void deliver(Order order) {
        System.out.println("[Loja] pedido " + order.getId() + " disponível para retirada");
    }
}
