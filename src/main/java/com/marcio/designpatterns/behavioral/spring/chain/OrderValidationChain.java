package com.marcio.designpatterns.behavioral.spring.chain;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CHAIN OF RESPONSIBILITY "à la Spring".
 *
 * Em vez de montar a corrente manualmente com linkWith() (como no GoF),
 * o Spring injeta a lista de todas as OrderRule já ORDENADAS pela
 * anotação @Order em cada bean. Adicionar uma nova regra de validação
 * é só criar a classe e anotá-la -- ninguém precisa "religar a corrente".
 */
@Component
public class OrderValidationChain {

    private final List<OrderRule> rules;

    public OrderValidationChain(List<OrderRule> rules) {
        this.rules = rules;
    }

    public void validate(Order order) {
        for (OrderRule rule : rules) {
            rule.check(order);
        }
    }
}
