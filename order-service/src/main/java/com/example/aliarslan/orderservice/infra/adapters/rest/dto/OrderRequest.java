package com.example.aliarslan.orderservice.infra.adapters.rest.dto;

import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.domain.order.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotNull
    private Integer status;

    @NotNull
    private BigDecimal price;

    public OrderCreate toModel() {
        return OrderCreate.builder()
                .status(OrderStatus.of(status))
                .price(price)
                .build();
    }
}
