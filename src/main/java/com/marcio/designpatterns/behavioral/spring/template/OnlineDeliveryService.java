package com.marcio.designpatterns.behavioral.spring.template;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Service;

@Service("online")
public class OnlineDeliveryService extends OrderDeliveryProcessor {
    @Override
    protected void deliver(Order order) {
        System.out.println("[Frete] enviando pedido " + order.getId() + " via transportadora");
    }
}
