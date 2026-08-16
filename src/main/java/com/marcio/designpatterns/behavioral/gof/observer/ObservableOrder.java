package com.marcio.designpatterns.behavioral.gof.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * OBSERVER clássico (GoF).
 *
 * Envolve um Order e mantém uma lista de observadores interessados em
 * mudanças de status. Quando o status muda, TODOS os observadores são
 * notificados, sem que o Order (ou quem muda o status) precise saber
 * quem são ou quantos são -- baixo acoplamento entre o "assunto" e
 * seus "ouvintes".
 *
 * (Evitamos estender java.util.Observable porque está deprecated desde
 * o Java 9; esta é a forma moderna de implementar o padrão à mão.)
 */
public class ObservableOrder {

    private final Order order;
    private final List<OrderObserver> observers = new ArrayList<>();

    public ObservableOrder(Order order) {
        this.order = order;
    }

    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    public void changeStatus(OrderStatus newStatus) {
        OrderStatus previous = order.getStatus();
        order.setStatus(newStatus);
        for (OrderObserver observer : observers) {
            observer.onStatusChanged(order, previous);
        }
    }

    public Order getOrder() {
        return order;
    }
}
