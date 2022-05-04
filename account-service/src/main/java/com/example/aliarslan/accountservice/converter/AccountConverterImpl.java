package com.example.aliarslan.accountservice.converter;

import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.converter.model.AccountResponse;
import com.example.aliarslan.accountservice.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountConverterImpl implements AccountConverter {

    @Override
    public Account toAccountFromAccountRequest(AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());
        account.setMailAddress(accountRequest.getMailAddress());
        return account;
    }

    @Override
    public Account toAccountFromAccountRequest(Account account, AccountRequest accountRequest) {
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());
        account.setMailAddress(accountRequest.getMailAddress());
        return account;
    }

    @Override
    public AccountResponse toAccountResponseFromAccountEntity(Account account) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setUserId(account.getId());
        accountResponse.setUsername(account.getUsername());
        accountResponse.setMailAddress(account.getMailAddress());
        accountResponse.setCreatedAt(account.getCreatedAt());
        accountResponse.setIsActive(account.getIsActive());
        return accountResponse;
    }

    @Override
    public List<AccountResponse> toAccountResponseListFromAccountEntityList(List<Account> accountList) {
        return accountList.stream().map(this::toAccountResponseFromAccountEntity).collect(Collectors.toList());
    }
}
