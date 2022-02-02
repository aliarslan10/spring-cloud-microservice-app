package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.domain.order.OrderRepository;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;

import java.util.List;

public class OrderMysqlRepositoryAdaptor implements OrderRepository {

    public Order save(OrderCreate orderRequest) {
        //Order order = orderConverter.toOrderFromOrderRequest(orderRequest);
        // orderMysqlRepository.save(order);
        return null;
    }

    @Override
    public Order get(String id) {
        return null;
    }

    @Override
    public Order update(OrderCreate orderRequest, String orderId) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
