package com.marcio.designpatterns.web;

import java.util.List;

public record CreateOrderRequest(
        String customerId,
        String customerName,
        String customerEmail,
        boolean vip,
        List<ItemRequest> items
) {
    public record ItemRequest(String productId, String productName, java.math.BigDecimal price, int quantity) {}
}
