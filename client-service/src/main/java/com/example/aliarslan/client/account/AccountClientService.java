package com.example.aliarslan.client.account;

import com.example.aliarslan.client.account.model.AccountServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service-client", url = "localhost:8090")
public interface AccountClientService {

    @GetMapping("/accounts/{id}")
    ResponseEntity<AccountServiceResponse> getAccount(@PathVariable("id") String accountId);
}
