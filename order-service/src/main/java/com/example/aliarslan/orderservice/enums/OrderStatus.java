package com.example.aliarslan.orderservice.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NEW_ORDER, PROCESSING, SHIPPED, DELIVERED, CANCELED
}