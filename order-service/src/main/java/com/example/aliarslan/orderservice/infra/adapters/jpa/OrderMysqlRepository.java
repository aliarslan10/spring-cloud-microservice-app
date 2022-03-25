package com.example.aliarslan.orderservice.infra.adapters.jpa;

import com.example.aliarslan.orderservice.infra.adapters.jpa.entity.OrderMysqlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMysqlRepository extends JpaRepository<OrderMysqlEntity, String> {

    List<OrderMysqlEntity> findAllByUserId(String userId);
}
