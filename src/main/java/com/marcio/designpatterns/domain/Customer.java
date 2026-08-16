package com.marcio.designpatterns.domain;

public record Customer(String id, String name, String email, boolean vip, Address address) {
}
