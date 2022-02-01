package com.example.aliarslan.orderservice.converter;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;

public interface OrderConverter<T> {

    T toOrderFromOrderRequest(OrderRequest accountRequest);

    T toOrderFromOrderRequest(T account, OrderRequest accountRequest);
}
