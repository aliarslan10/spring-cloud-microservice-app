package com.example.aliarslan.orderservice.service.impl;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public OrderResponse get(String id) {
        return null;
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest, String orderId) {
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
