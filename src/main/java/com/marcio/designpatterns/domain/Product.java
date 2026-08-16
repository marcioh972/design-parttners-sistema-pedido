package com.marcio.designpatterns.domain;

import java.math.BigDecimal;

public record Product(String id, String name, BigDecimal price) {
}
