package com.marcio.designpatterns.structural.gof.facade;

import com.marcio.designpatterns.domain.Order;

public class NotificationSystem {
    public void notifyCustomer(Order order, String message) {
        System.out.printf("[Notificação] para %s: %s%n", order.getCustomer().email(), message);
    }
}
