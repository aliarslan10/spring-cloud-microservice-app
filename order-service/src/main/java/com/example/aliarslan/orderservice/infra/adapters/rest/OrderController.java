package com.example.aliarslan.orderservice.infra.adapters.rest;

import com.example.aliarslan.orderservice.domain.order.OrderFacade;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderFacade orderFacade;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid OrderCreate orderRequest) {
        Order order = orderFacade.save(orderRequest);
        return ResponseEntity.ok(OrderResponse.fromModel(order));
    }

    @GetMapping("/id")
    public ResponseEntity<OrderResponse> get(@PathVariable("id") String orderId) {
        return ResponseEntity.ok(orderFacade.get(orderId));
    }

    @PutMapping("/id")
    public ResponseEntity<OrderResponse> update(@PathVariable("id") String orderId, @Valid @RequestBody OrderCreate orderRequest) {
        return ResponseEntity.ok(orderFacade.update(orderRequest, orderId));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") String orderId) {
        orderFacade.delete(orderId);
        ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() {
        return ResponseEntity.ok(orderFacade.getAll());
    }
}
