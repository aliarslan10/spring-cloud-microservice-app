package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.domain.exception.OrderNotFoundException;
import com.example.aliarslan.orderservice.domain.order.OrderRepository;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.jpa.entity.OrderMysqlEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMysqlRepositoryAdaptor implements OrderRepository {

    private final OrderMysqlRepository orderMysqlRepository;

    public Order save(OrderCreate orderCreate) {
        OrderMysqlEntity orderMysqlEntity = new OrderMysqlEntity();
        orderMysqlEntity.setPrice(orderCreate.getPrice());
        orderMysqlEntity.setStatus(orderCreate.getStatus());
        orderMysqlEntity.setCreatedAt(LocalDateTime.now());
        orderMysqlEntity.setUserId(orderCreate.getUserId());
        orderMysqlRepository.save(orderMysqlEntity);
        return toModel(orderMysqlEntity);
    }

    @Override
    public Order get(String id) {
        return toModel(orderMysqlRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("orderService.order.notFound")));
    }

    @Override
    public Order update(OrderCreate orderRequest, String orderId) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Order> getAll(String userId) {
        return orderMysqlRepository.findAllByUserId(userId).stream().map(this::toModel).collect(Collectors.toList());
    }

    private Order toModel(OrderMysqlEntity orderMysqlEntity) {
        return Order.builder()
                .id(orderMysqlEntity.getId())
                .price(orderMysqlEntity.getPrice())
                .status(orderMysqlEntity.getStatus())
                .userId(orderMysqlEntity.getUserId())
                .createdDate(orderMysqlEntity.getCreatedAt())
                .build();
    }
}
