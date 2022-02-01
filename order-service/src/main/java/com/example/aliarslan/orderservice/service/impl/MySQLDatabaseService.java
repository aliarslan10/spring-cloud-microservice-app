package com.example.aliarslan.orderservice.service.impl;

import com.example.aliarslan.orderservice.converter.OrderConverter;
import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.entity.mysql.Order;
import com.example.aliarslan.orderservice.repository.OrderMysqlRepository;
import com.example.aliarslan.orderservice.service.OrderDatabaseService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MySQLDatabaseService implements OrderDatabaseService<Order> {

    private final OrderMysqlRepository orderMysqlRepository;
    private final OrderConverter<Order> orderConverter;

    @Override
    public Order save(OrderRequest orderRequest) {
        Order order = orderConverter.toOrderFromOrderRequest(orderRequest);
        orderMysqlRepository.save(order);
        return order;
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
