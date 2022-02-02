package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.jpa.OrderElasticsearchRepositoryAdaptor;
import com.example.aliarslan.orderservice.infra.adapters.jpa.OrderMysqlRepositoryAdaptor;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class OrderFacade {

    private OrderRepository orderRepository;

    @Transactional
    public Order save(OrderCreate orderCreate) {
        Order order = saveToMysql(orderCreate);
        saveToElasticsearch(orderCreate);
        return null;
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
        orderRepository = new OrderMysqlRepositoryAdaptor();
        return orderRepository.save(orderCreate);
    }

    private void saveToElasticsearch(OrderCreate orderCreate) {
        orderRepository = new OrderElasticsearchRepositoryAdaptor();
        orderRepository.save(orderCreate);
    }
}
