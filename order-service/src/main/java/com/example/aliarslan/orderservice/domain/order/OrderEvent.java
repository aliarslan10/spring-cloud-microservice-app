package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.orderservice.domain.order.model.Order;

public interface OrderEvent {

    void sendToQueue(Order order);
}
