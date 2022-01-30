package com.example.aliarslan.orderservice.repository;

import com.example.aliarslan.orderservice.entity.elastichsearch.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderElasticsearchRepository extends ElasticsearchRepository<Order, String> {
}