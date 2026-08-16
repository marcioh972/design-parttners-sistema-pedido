package com.marcio.designpatterns.behavioral.spring.chain;

import com.marcio.designpatterns.behavioral.gof.chain.OrderValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class StockRule implements OrderRule {
    @Override
    public void check(com.marcio.designpatterns.domain.Order order) {
        if (order.getItems().isEmpty()) {
            throw new OrderValidationException("Pedido sem itens em estoque");
        }
        System.out.println("[Validação] estoque OK para pedido " + order.getId());
    }
}
