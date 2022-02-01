package com.example.aliarslan.orderservice.service.impl;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MySQLDatabaseService mySQLDatabaseService;
    private final ElasticsearchDatabaseService elasticsearchDatabaseService;

    @Override
    @Transactional
    public OrderResponse save(OrderRequest orderRequest) {
        OrderStrategy mysql = new OrderStrategy(mySQLDatabaseService);
        mysql.saveQuery(orderRequest);

        OrderStrategy elasticsearch = new OrderStrategy(elasticsearchDatabaseService);
        elasticsearch.saveQuery(orderRequest);

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
