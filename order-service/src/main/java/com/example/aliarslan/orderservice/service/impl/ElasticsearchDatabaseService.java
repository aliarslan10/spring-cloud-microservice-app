package com.example.aliarslan.orderservice.service.impl;

import com.example.aliarslan.orderservice.converter.OrderConverter;
import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.entity.elastichsearch.Order;
import com.example.aliarslan.orderservice.repository.OrderElasticsearchRepository;
import com.example.aliarslan.orderservice.service.OrderDatabaseService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ElasticsearchDatabaseService implements OrderDatabaseService<Order> {

    private final OrderElasticsearchRepository orderElasticsearchRepository;
    private final OrderConverter<Order> orderConverter;

    @Override
    public Order save(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public Order get(String id) {
        return null;
    }

    @Override
    public Order update(OrderRequest orderRequest, String orderId) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<OrderResponse> getAll() {
        return null;
    }
}
