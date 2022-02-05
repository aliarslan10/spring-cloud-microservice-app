package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.jpa.OrderElasticsearchRepositoryAdaptor;
import com.example.aliarslan.orderservice.infra.adapters.jpa.OrderMysqlRepositoryAdaptor;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderElasticsearchRepositoryAdaptor orderElasticsearchRepositoryAdaptor;
    private final OrderMysqlRepositoryAdaptor orderMysqlRepositoryAdaptor;

    @Transactional
    public Order save(OrderCreate orderCreate) {
        Order order = saveToMysql(orderCreate);
        saveToElasticsearch(orderCreate);
        return order;
    }

    public OrderResponse get(String id) {
        return null;
    }

    public OrderResponse update(OrderCreate orderCreate, String orderId) {
        return null;
    }

    public void delete(String id) {}

    public List<OrderResponse> getAll() {
        return null;
    }

    private Order saveToMysql(OrderCreate orderCreate) {
        return orderMysqlRepositoryAdaptor.save(orderCreate);
    }

    private void saveToElasticsearch(OrderCreate orderCreate) {
        orderElasticsearchRepositoryAdaptor.save(orderCreate);
    }
}
