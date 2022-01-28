package com.example.aliarslan.orderservice.controller;

import com.example.aliarslan.orderservice.converter.model.OrderRequest;
import com.example.aliarslan.orderservice.converter.model.OrderResponse;
import com.example.aliarslan.orderservice.service.OrderService;
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

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.save(orderRequest));
    }

    @GetMapping("/id")
    public ResponseEntity<OrderResponse> get(@PathVariable("id") String orderId) {
        return ResponseEntity.ok(orderService.get(orderId));
    }

    @PutMapping("/id")
    public ResponseEntity<OrderResponse> update(@PathVariable("id") String orderId, @Valid @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.update(orderRequest, orderId));
    }

    @DeleteMapping
    public void delete(@PathVariable("id") String orderId) {
        orderService.delete(orderId);
        ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
