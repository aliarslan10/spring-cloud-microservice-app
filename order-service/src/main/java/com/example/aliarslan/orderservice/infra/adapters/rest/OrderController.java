package com.example.aliarslan.orderservice.infra.adapters.rest;

import com.example.aliarslan.orderservice.domain.order.OrderFacade;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import com.example.aliarslan.orderservice.domain.order.model.OrderCreate;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderRequest;
import com.example.aliarslan.orderservice.infra.adapters.rest.dto.OrderResponse;
import com.example.aliarslan.orderservice.infra.common.rest.BaseController;
import com.example.aliarslan.orderservice.infra.common.rest.DataResponse;
import com.example.aliarslan.orderservice.infra.common.rest.Response;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends BaseController {

    private final OrderFacade orderFacade;

    @PostMapping
    public Response<OrderResponse> save(@RequestBody @Valid OrderRequest orderRequest) {
        OrderCreate orderCreate = orderRequest.toModel();
        Order order = orderFacade.save(orderCreate);
        return respond(OrderResponse.fromModel(order));
    }

    @GetMapping("/{orderId}/users/{userId}")
    public Response<OrderResponse> get(@PathVariable("orderId") String orderId, @PathVariable("userId") String userId) {
        Order order = orderFacade.get(orderId, userId);
        return respond(order.toResponse());
    }

    @GetMapping("/search/{keyword}/users/{userId}")
    public Response<OrderResponse>  search(@PathVariable("id") String keyword, @PathVariable("userId") String userId) {
        Order order = orderFacade.search(keyword, userId);
        return respond(order.toResponse());
    }

    @PutMapping("/users/{userId}")
    public Response<OrderResponse> update(@PathVariable("userId") String userId, @Valid @RequestBody OrderRequest orderRequest) {
        OrderCreate orderCreate = orderRequest.toModel();
        return respond(orderFacade.update(orderCreate, userId));
    }

    @DeleteMapping("/{orderId}/users/{userId}")
    public void delete(@PathVariable("orderId") String orderId, @PathVariable("userId") String userId) {
        orderFacade.delete(orderId, userId);
        ResponseEntity.ok();
    }

    @GetMapping("/users/{userId}")
    public Response<DataResponse<OrderResponse>> getAll() {
        return respond(orderFacade.getAll());
    }
}
