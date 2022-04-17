package com.example.aliarslan.gatewayserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class HystrixFallbackController {

    @GetMapping("/accounts")
    public String accountServiceFallback(){
        return "Account Service is not available.";
    }

    @GetMapping("/orders")
    public String orderServiceFallback(){
        return "Order Service is not available.";
    }
}
