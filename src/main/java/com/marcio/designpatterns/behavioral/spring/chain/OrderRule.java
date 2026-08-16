package com.marcio.designpatterns.behavioral.spring.chain;

import com.marcio.designpatterns.domain.Order;

public interface OrderRule {
    void check(Order order);
}
