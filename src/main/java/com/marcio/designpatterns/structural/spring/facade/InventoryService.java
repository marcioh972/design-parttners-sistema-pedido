package com.marcio.designpatterns.structural.spring.facade;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    public void reserve(Order order) {
        System.out.println("[Estoque] reservando itens do pedido " + order.getId());
    }
}
