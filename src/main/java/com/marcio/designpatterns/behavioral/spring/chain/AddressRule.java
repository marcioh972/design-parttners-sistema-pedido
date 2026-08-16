package com.marcio.designpatterns.behavioral.spring.chain;

import com.marcio.designpatterns.behavioral.gof.chain.OrderValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AddressRule implements OrderRule {
    @Override
    public void check(com.marcio.designpatterns.domain.Order order) {
        if (order.getCustomer().address() == null) {
            throw new OrderValidationException("Cliente sem endereço de entrega cadastrado");
        }
        System.out.println("[Validação] endereço OK para pedido " + order.getId());
    }
}
