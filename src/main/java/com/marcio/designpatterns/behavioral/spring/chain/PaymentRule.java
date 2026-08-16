package com.marcio.designpatterns.behavioral.spring.chain;

import com.marcio.designpatterns.behavioral.gof.chain.OrderValidationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Order(3)
public class PaymentRule implements OrderRule {
    @Override
    public void check(com.marcio.designpatterns.domain.Order order) {
        if (order.subtotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new OrderValidationException("Valor do pedido inválido");
        }
        System.out.println("[Validação] valores OK para pedido " + order.getId());
    }
}
