package com.example.aliarslan.orderservice.converter.model;

import com.example.aliarslan.orderservice.enums.OrderStatus;

import java.math.BigDecimal;

public class OrderResponse {

    private String orderId;
    private OrderStatus status;
    private BigDecimal price;
}
