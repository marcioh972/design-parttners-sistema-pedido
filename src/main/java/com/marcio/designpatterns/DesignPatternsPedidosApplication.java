package com.marcio.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sistema de Pedidos usado como laboratório de Design Patterns.
 *
 * Cada padrão GoF aparece em dois pacotes irmãos:
 *   - *.gof.*    -> implementação clássica, em Java puro, sem o container.
 *   - *.spring.* -> a mesma intenção resolvida com os recursos do Spring
 *                   (injeção de dependência, eventos, escopos de bean, etc).
 *
 * Veja o README.md na raiz do projeto para o mapa completo.
 */
@SpringBootApplication
public class DesignPatternsPedidosApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsPedidosApplication.class, args);
    }
}
