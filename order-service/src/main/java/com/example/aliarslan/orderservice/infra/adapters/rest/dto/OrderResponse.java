package com.example.aliarslan.orderservice.infra.adapters.rest.dto;

import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private String orderId;
    private OrderStatus status;
    private BigDecimal price;
    private String userId;
    private LocalDateTime createdDate;

    public static OrderResponse fromModel(Order order) {
        return OrderResponse.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .price(order.getPrice())
                .userId(order.getUserId())
                .createdDate(order.getCreatedDate())
                .build();
    }
}
