package com.example.aliarslan.notificationservice;

import com.example.aliarslan.notificationservice.model.OrderNotificationMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationListener {

    @StreamListener
    public void notificationListener(OrderNotificationMessage orderNotificationMessage) {
        System.out.println("Notification received." + orderNotificationMessage.getOrderId());
    }
}
