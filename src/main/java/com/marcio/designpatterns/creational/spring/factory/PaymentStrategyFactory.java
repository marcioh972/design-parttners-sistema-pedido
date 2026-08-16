package com.marcio.designpatterns.creational.spring.factory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * FACTORY METHOD "à la Spring".
 *
 * Em vez de um switch/case que precisa ser editado a cada novo meio de
 * pagamento, o Spring injeta automaticamente TODOS os beans que
 * implementam PaymentStrategy num Map, indexados pelo nome do bean
 * (o valor passado em @Component("pix"), por exemplo).
 *
 * Para adicionar um novo meio de pagamento (ex: "boleto-bancario"),
 * basta criar a classe com @Component("chave") -- esta factory nem
 * precisa ser tocada. Isso é o Open/Closed Principle na prática,
 * habilitado pelo container fazendo a "fábrica" por injeção.
 */
@Component
public class PaymentStrategyFactory {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategyFactory(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public String charge(String type, BigDecimal amount) {
        PaymentStrategy strategy = strategies.get(type.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Meio de pagamento desconhecido: " + type);
        }
        return strategy.charge(amount);
    }
}
