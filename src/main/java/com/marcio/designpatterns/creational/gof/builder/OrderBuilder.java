package com.marcio.designpatterns.creational.gof.builder;

import com.marcio.designpatterns.creational.gof.singleton.OrderIdGenerator;
import com.marcio.designpatterns.domain.Customer;
import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderItem;
import com.marcio.designpatterns.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * BUILDER clássico (GoF).
 *
 * Um Order tem várias partes (cliente, itens...) e construí-lo com um
 * construtor telescópico (muitos parâmetros, várias sobrecargas) fica
 * confuso e frágil. O Builder monta o objeto passo a passo com uma API
 * fluente e só "libera" o objeto pronto no build().
 *
 * Uso típico:
 *   Order pedido = new OrderBuilder()
 *       .forCustomer(cliente)
 *       .addItem(produtoX, 2)
 *       .addItem(produtoY, 1)
 *       .build();
 */
public class OrderBuilder {

    private Customer customer;
    private final List<OrderItem> items = new ArrayList<>();

    public OrderBuilder forCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder addItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.items.add(new OrderItem(product, quantity));
        return this;
    }

    public Order build() {
        if (customer == null) {
            throw new IllegalStateException("Pedido precisa de um cliente");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Pedido precisa de ao menos um item");
        }
        String id = OrderIdGenerator.getInstance().nextId();
        return new Order(id, customer, items);
    }
}
