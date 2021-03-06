package com.example.aliarslan.orderservice.domain.order.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderCreate {

    private String userId;
    private OrderStatus status;
    private BigDecimal price;
}
