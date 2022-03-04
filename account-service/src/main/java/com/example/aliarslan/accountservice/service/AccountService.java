package com.example.aliarslan.accountservice.service;

import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(AccountRequest account);
    Account get(String id);
    Account update(AccountRequest accountRequest, String accountId);
    void delete(String id);
    List<Account> getAll();
}
