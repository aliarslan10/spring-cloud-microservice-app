package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.domain.order.OrderSearchRepository;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.jpa.entity.OrderElasticsearchEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderElasticsearchRepositoryAdaptor implements OrderSearchRepository {

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
    public Order search(String value) {
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
