package com.example.aliarslan.accountservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("accounts")
public class Account {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column
    private String username;

    @Column
    private String mailAddress;

    @Column
    private String password;

    @Column(value = "created_at")
    private LocalDate createdAt;

    @Column(value = "is_active")
    private Boolean isActive;
}
