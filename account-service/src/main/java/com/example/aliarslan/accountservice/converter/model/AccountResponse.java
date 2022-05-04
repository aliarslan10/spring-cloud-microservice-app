package com.example.aliarslan.accountservice.converter.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountResponse {

    private String userId;
    private String username;
    private String mailAddress;
    private LocalDate createdAt;
    private Boolean isActive;
}
