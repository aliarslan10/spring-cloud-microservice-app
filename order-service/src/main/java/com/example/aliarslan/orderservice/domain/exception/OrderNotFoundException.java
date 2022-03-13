package com.example.aliarslan.orderservice.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderNotFoundException extends RuntimeException {

    private final String key;
    private final String[] args;

    public OrderNotFoundException(String key) {
        super(key);
        this.key = key;
        args = new String[0];
    }

    public OrderNotFoundException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}
