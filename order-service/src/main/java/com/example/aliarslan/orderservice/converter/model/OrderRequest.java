package com.example.aliarslan.orderservice.converter.model;

import com.example.aliarslan.orderservice.enums.OrderStatus;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class OrderRequest {

    @NotBlank
    OrderStatus status;

    @NotBlank
    BigDecimal price;
}
