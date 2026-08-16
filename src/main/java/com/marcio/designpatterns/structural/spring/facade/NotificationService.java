package com.marcio.designpatterns.structural.spring.facade;

import com.marcio.designpatterns.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyCustomer(Order order, String message) {
        System.out.printf("[Notificação] para %s: %s%n", order.getCustomer().email(), message);
    }
}
