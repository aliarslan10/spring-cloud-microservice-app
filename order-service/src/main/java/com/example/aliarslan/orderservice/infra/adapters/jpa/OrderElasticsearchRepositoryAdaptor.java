package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.domain.order.OrderRepository;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.jpa.entity.OrderElasticsearchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderElasticsearchRepositoryAdaptor implements OrderRepository {

    private final OrderElasticsearchRepository orderElasticsearchRepository;

    @Override
    public Order save(OrderCreate orderCreate) {
        OrderElasticsearchEntity orderElasticsearchEntity = new OrderElasticsearchEntity();
        orderElasticsearchEntity.setPrice(orderCreate.getPrice());
        orderElasticsearchEntity.setStatus(orderCreate.getStatus());
        OrderElasticsearchEntity savedOrderEntity = orderElasticsearchRepository.save(orderElasticsearchEntity);
        return toModel(savedOrderEntity);
    }

    @Override
    public Order get(String id) {
        return null;
    }

    @Override
    public Order update(OrderCreate orderCreate, String orderId) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    private Order toModel(OrderElasticsearchEntity orderElasticsearchEntity) {
        return Order.builder()
                .id(orderElasticsearchEntity.getId())
                .price(orderElasticsearchEntity.getPrice())
                .createdDate(orderElasticsearchEntity.getCreatedAt())
                .build();
    }
}
