package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.infra.adapters.jpa.entity.OrderElasticsearchEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderElasticsearchRepository extends ElasticsearchRepository<OrderElasticsearchEntity, String> {
}