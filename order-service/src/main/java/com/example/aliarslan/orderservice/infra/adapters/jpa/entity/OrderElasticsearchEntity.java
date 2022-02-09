package com.example.aliarslan.orderservice.infra.adapters.jpa.entity;

import com.example.aliarslan.orderservice.domain.order.model.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document(indexName = "orders")
public class OrderElasticsearchEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    BigDecimal price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}