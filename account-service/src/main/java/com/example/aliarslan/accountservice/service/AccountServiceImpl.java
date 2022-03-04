package com.example.aliarslan.accountservice.service;

import com.example.aliarslan.accountservice.converter.AccountConverter;
import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.entity.Account;
import com.example.aliarslan.accountservice.exception.AccountNotFoundException;
import com.example.aliarslan.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;

    @Override
    public Account save(AccountRequest accountRequest) {
        Account account = accountConverter.toAccountFromAccountRequest(accountRequest);
        account.setCreatedAt(LocalDate.now());
        account.setIsActive(true);
        return accountRepository.save(account);
    }

    @Override
    public Account get(String accountId) {
        return accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public Account update(AccountRequest accountRequest, String accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        return accountRepository.save(accountConverter.toAccountFromAccountRequest(account, accountRequest));
    }

    @Override
    public void delete(String accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        accountRepository.delete(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
