package com.example.aliarslan.notificationservice;

import com.example.aliarslan.notificationservice.model.OrderEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationListener {

    @StreamListener
    public void orderListener(OrderEvent orderEvent) {
        System.out.println("Notification received : " + orderEvent);
    }
}
