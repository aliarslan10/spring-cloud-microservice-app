package com.example.aliarslan.orderservice.infra.adapters.event;

import com.example.aliarslan.orderservice.domain.order.OrderEvent;
import com.example.aliarslan.orderservice.domain.order.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class OrderEventPublisher implements OrderEvent {

    private final Source source;

    @Override
    public void sendToQueue(Order order) {
        source.output().send(MessageBuilder.withPayload(order).build());
    }
}
