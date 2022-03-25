package com.example.aliarslan.orderservice.domain.order;

import com.example.aliarslan.client.account.AccountClientService;
import com.example.aliarslan.orderservice.domain.exception.OrderBusinessException;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderRepository orderRepository;
    private final OrderSearchRepository orderSearchRepository;
    private final AccountClientService accountClientService;

    @Transactional
    public Order save(OrderCreate orderCreate) {
        checkIfUserExist(orderCreate.getUserId());
        Order order = saveToMysql(orderCreate);
        saveToElasticsearch(orderCreate);
        return order;
    }

    public Order get(String orderId, String userId) {
        checkIfUserExist(userId);
        return orderRepository.get(orderId);
    }

    public Order search(String keyword, String userId) {
        return orderSearchRepository.search(keyword);
    }

    public OrderResponse update(OrderCreate orderCreate, String userId) {
        return null;
    }

    public void delete(String id, String userId) {}

    public List<Order> getAll(String userId) {
        checkIfUserExist(userId);
        return orderRepository.getAll(userId);
    }

    private Order saveToMysql(OrderCreate orderCreate) {
        return orderRepository.save(orderCreate);
    }

    private void saveToElasticsearch(OrderCreate orderCreate) {
        orderSearchRepository.save(orderCreate);
    }

    private void checkIfUserExist(String userId) {
        Optional.ofNullable(accountClientService.getAccount(userId).getBody())
                .orElseThrow(() -> new OrderBusinessException("orderService.user.notFound"));
    }
}
