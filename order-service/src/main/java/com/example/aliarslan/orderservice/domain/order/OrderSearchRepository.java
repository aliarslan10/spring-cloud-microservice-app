package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;

public interface OrderSearchRepository {

    Order save(OrderCreate orderRequest);

    Order search(String value);
}
