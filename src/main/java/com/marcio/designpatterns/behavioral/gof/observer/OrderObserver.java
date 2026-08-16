package com.marcio.designpatterns.behavioral.gof.observer;

import com.marcio.designpatterns.domain.Order;
import com.marcio.designpatterns.domain.OrderStatus;

public interface OrderObserver {
    void onStatusChanged(Order order, OrderStatus previousStatus);
}
