package com.marcio.designpatterns.structural.spring.facade;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public String schedule(Order order) {
        System.out.println("[Frete] agendando envio do pedido " + order.getId());
        return "BR" + System.nanoTime() % 1_000_000 + "9SP";
    }
}
