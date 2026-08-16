package com.marcio.designpatterns.creational.spring.singleton;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * SINGLETON "à la Spring".
 *
 * A mesma garantia de instância única do padrão GoF, mas sem escrever
 * NENHUMA linha de lógica de singleton: o escopo padrão de todo @Bean
 * no Spring já é "singleton" (uma instância por ApplicationContext).
 *
 * Compare com OrderIdGenerator (pacote irmão .gof.singleton):
 *   - lá: construtor privado + Holder estático + getInstance()
 *   - aqui: o container cuida disso; você só injeta via @Autowired/construtor.
 *
 * Curiosidade: se algum dia precisar de uma instância NOVA por injeção
 * (o oposto do singleton), basta anotar com @Scope("prototype").
 */
@Component
public class SpringOrderIdGenerator {

    private final AtomicLong counter = new AtomicLong(1000);

    public String nextId() {
        return "PED-" + counter.incrementAndGet();
    }
}
