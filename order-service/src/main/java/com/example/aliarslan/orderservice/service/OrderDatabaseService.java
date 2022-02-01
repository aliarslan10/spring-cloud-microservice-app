package com.example.aliarslan.orderservice.service;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;

import java.util.List;

public interface OrderDatabaseService<T> {

    T save(OrderRequest orderRequest);

    T get(String id);

    T update(OrderRequest orderRequest, String orderId);

    void delete(String id);

    List<OrderResponse> getAll();
}
