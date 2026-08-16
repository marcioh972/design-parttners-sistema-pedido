package com.marcio.designpatterns.behavioral.spring.strategy;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * STRATEGY "à la Spring".
 *
 * Em vez de escolher a estratégia manualmente (new VipDiscountStrategy()),
 * o Spring injeta a LISTA de todos os beans DiscountPolicy encontrados no
 * classpath (na ordem definida por @Order). O resolver só pergunta
 * "quem se aplica a este pedido?" -- adicionar uma nova política de
 * desconto não exige tocar nesta classe, só criar o novo @Component.
 */
@Component
public class DiscountResolver {

    private final List<DiscountPolicy> policies;

    public DiscountResolver(List<DiscountPolicy> policies) {
        this.policies = policies;
    }

    public BigDecimal calculateFinalPrice(Order order) {
        BigDecimal amount = order.subtotal();
        for (DiscountPolicy policy : policies) {
            if (policy.supports(order)) {
                return policy.applyDiscount(order, amount);
            }
        }
        return amount;
    }
}
