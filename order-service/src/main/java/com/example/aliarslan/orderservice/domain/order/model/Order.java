package com.example.aliarslan.orderservice.domain.order.model;

import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
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
    private String userId;
    private LocalDateTime createdDate;

    public OrderResponse toResponse() {
        return OrderResponse.builder()
                .orderId(id)
                .status(status)
                .price(price)
                .userId(userId)
                .createdDate(createdDate)
                .build();
    }
}