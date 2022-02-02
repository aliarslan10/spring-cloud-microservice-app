package com.example.aliarslan.orderservice.infra.adapters.rest.dto;

import com.example.aliarslan.orderservice.domain.order.model.OrderStatus;

import java.math.BigDecimal;

public class OrderRequest {

    OrderStatus status;

    BigDecimal price;
}
