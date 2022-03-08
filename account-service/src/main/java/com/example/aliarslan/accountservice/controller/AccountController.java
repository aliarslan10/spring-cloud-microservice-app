package com.example.aliarslan.accountservice.controller;

import com.example.aliarslan.accountservice.converter.AccountConverter;
import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.converter.model.AccountResponse;
import com.example.aliarslan.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountConverter accountConverter;

    @PostMapping
    public ResponseEntity<AccountResponse> save(@Valid @RequestBody AccountRequest accountRequest) {
        return ResponseEntity.ok(accountConverter.toAccountResponseFromAccountEntity(accountService.save(accountRequest)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> get(@PathVariable("id") String accountId) {
        return ResponseEntity.ok(accountConverter.toAccountResponseFromAccountEntity(accountService.get(accountId)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponse> update(@Valid @RequestBody AccountRequest accountRequest, @PathVariable("id") String accountId) {
        return ResponseEntity.ok(accountConverter.toAccountResponseFromAccountEntity(accountService.update(accountRequest, accountId)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String accountId) {
        accountService.delete(accountId);
        ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAll() {
        return ResponseEntity.ok(accountConverter.toAccountResponseListFromAccountEntityList(accountService.getAll()));
    }
}
