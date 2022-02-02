package com.example.aliarslan.orderservice.domain.order.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Order {

    private String id;
    private OrderStatus status;
    private BigDecimal price;
    private LocalDateTime createdDate;
}