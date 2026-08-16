package com.marcio.designpatterns.domain;

import java.math.BigDecimal;

public record OrderItem(Product product, int quantity) {

    public BigDecimal subtotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}
