package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;

import java.util.List;

public interface OrderRepository {

    Order save(OrderCreate orderRequest);

    Order get(String id);

    Order update(OrderCreate orderRequest, String orderId);

    void delete(String id);

    List<Order> getAll(String userId);
}
