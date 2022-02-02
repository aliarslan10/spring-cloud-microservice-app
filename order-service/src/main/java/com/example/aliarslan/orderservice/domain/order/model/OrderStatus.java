package com.example.aliarslan.orderservice.domain.order.model;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum OrderStatus {
    NEW_ORDER(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final Integer value;

    OrderStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static OrderStatus of(Integer value) {
        return Stream.of(OrderStatus.values())
                .filter(status -> status.value.equals(value)).findFirst().orElseThrow();
    }
}