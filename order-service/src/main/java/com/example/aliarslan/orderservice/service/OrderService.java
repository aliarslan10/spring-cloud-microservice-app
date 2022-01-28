package com.example.aliarslan.orderservice.service;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse save(OrderRequest orderRequest);

    OrderResponse get(String id);

    OrderResponse update(OrderRequest orderRequest, String orderId);

    void delete(String id);

    List<OrderResponse> getAll();
}
