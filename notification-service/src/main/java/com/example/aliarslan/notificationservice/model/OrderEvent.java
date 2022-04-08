package com.example.aliarslan.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEvent {
    private String id;
    private String status;
    private BigDecimal price;
    private String userId;
    private LocalDateTime createdDate;
}
