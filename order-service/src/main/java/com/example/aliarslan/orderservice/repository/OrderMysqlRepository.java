package com.example.aliarslan.orderservice.repository;

import com.example.aliarslan.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMysqlRepository extends JpaRepository<Order, String> {
}
