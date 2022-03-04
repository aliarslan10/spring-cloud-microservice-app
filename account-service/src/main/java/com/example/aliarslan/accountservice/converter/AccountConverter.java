package com.example.aliarslan.accountservice.converter;

import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.converter.model.AccountResponse;
import com.example.aliarslan.accountservice.entity.Account;

import java.util.List;

public interface AccountConverter {

    Account toAccountFromAccountRequest(AccountRequest accountRequest);
    Account toAccountFromAccountRequest(Account account, AccountRequest accountRequest);
    AccountResponse toAccountResponseFromAccountEntity(Account account);
    List<AccountResponse> toAccountResponseListFromAccountEntityList(List<Account> accountList);
}
