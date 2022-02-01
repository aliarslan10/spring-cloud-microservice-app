package com.example.aliarslan.orderservice.service.impl;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.service.OrderDatabaseService;

import java.util.List;

public class OrderStrategy {

    private final OrderDatabaseService orderService;

    public OrderStrategy(OrderDatabaseService orderService) {
        this.orderService = orderService;
    }

    public Object saveQuery(OrderRequest orderRequest) {
        return orderService.save(orderRequest);
    }

    public Object getQuery(String id) {
        return orderService.get(id);
    }

    public Object updateQuery(OrderRequest orderRequest, String orderId) {
        return orderService.update(orderRequest, orderId);
    }

    public void deleteQuery(String id) {
        orderService.delete(id);
    }

    public List<OrderResponse> getAllQuery() {
        return orderService.getAll();
    }
}
