package com.marcio.designpatterns.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Agregado central do domínio. É intencionalmente "burro": não conhece
 * pagamento, estoque ou frete -- essas responsabilidades ficam nos padrões
 * (Strategy, Chain of Responsibility, Facade, etc.) que operam sobre ele.
 */
public class Order {

    private final String id;
    private final Customer customer;
    private final List<OrderItem> items;
    private final LocalDateTime createdAt;
    private OrderStatus status;
    private String paymentMethod;

    // Construtor "de pacote" -- só o Builder (mesmo pacote/GoF) ou quem
    // tiver acesso direto deve montar um Order. Veja creational.gof.builder.OrderBuilder.
    public Order(String id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.status = OrderStatus.CRIADO;
        this.createdAt = LocalDateTime.now();
    }

    public BigDecimal subtotal() {
        return items.stream()
                .map(OrderItem::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    @Override
    public String toString() {
        return "Order{id='%s', cliente='%s', status=%s, itens=%d, subtotal=%s}"
                .formatted(id, customer.name(), status, items.size(), subtotal());
    }
}
