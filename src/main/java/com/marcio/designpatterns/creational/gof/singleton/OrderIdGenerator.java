package com.marcio.designpatterns.creational.gof.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * SINGLETON clássico (GoF).
 *
 * Garante que exista apenas UMA instância do gerador de IDs em toda a JVM,
 * com acesso global via getInstance(). Usa o idiom "initialization-on-demand
 * holder", que é thread-safe sem precisar de synchronized em cada chamada.
 *
 * Problemas que esse padrão resolve manualmente (e que o Spring resolve
 * de graça, veja o par em creational.spring.singleton):
 *   - impedir múltiplas instâncias;
 *   - inicialização preguiçosa e thread-safe;
 *   - acesso global controlado (em vez de variáveis estáticas soltas).
 */
public final class OrderIdGenerator {

    private final AtomicLong counter = new AtomicLong(1000);

    private OrderIdGenerator() {
        // construtor privado: ninguém de fora pode instanciar
    }

    private static class Holder {
        private static final OrderIdGenerator INSTANCE = new OrderIdGenerator();
    }

    public static OrderIdGenerator getInstance() {
        return Holder.INSTANCE;
    }

    public String nextId() {
        return "PED-" + counter.incrementAndGet();
    }
}
