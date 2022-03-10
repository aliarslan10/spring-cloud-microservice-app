package com.example.aliarslan.accountservice.service;

import com.example.aliarslan.accountservice.converter.AccountConverterImpl;
import com.example.aliarslan.accountservice.converter.model.AccountRequest;
import com.example.aliarslan.accountservice.entity.Account;
import com.example.aliarslan.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Spy
    private AccountConverterImpl accountConverter;

    private Account accountModel;

    @BeforeEach
    public void init() {
        accountModel = new Account();
        accountModel.setId("1");
        accountModel.setUsername("aliarslan");
        accountModel.setMailAddress("ali@ali");
        accountModel.setPassword("password");
        accountModel.setIsActive(Boolean.TRUE);
        accountModel.setCreatedAt(LocalDate.now());
    }

    @Test
    public void whenSaveMethodCalledWithAccountRequest_shouldReturnAccount() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUsername("aliarslan");
        accountRequest.setMailAddress("ali@ali");
        accountRequest.setPassword("password");

        when(accountRepository.save(any())).thenReturn(accountModel);

        Account account = accountService.save(accountRequest);
        assertNotNull(account);
    }

    @Test
    public void whenGetMethodCalledWithAccountId_shouldReturnAccount() {
        when(accountRepository.findById(accountModel.getId())).thenReturn(Optional.of(accountModel));
        Account account = accountService.get(accountModel.getId());
        assertNotNull(account);
    }

    @Test
    public void whenUpdateMethodCalledWithAccountRequestAndAccountId_shouldReturnAccount() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setUsername("aliarslan");
        accountRequest.setMailAddress("ali@ali");
        accountRequest.setPassword("password");

        when(accountRepository.findById(accountModel.getId())).thenReturn(Optional.of(accountModel));
        when(accountRepository.save(any())).thenReturn(accountModel);

        Account account = accountService.update(accountRequest, accountModel.getId());

        assertNotNull(account);
    }

    @Test
    public void whenDeleteMethodCalledWithAccountId_shouldReturnNothing() {
        when(accountRepository.findById(accountModel.getId())).thenReturn(Optional.of(accountModel));
        accountService.delete(accountModel.getId());
    }

    @Test
    public void whenGetAllMethodCalledWithAccountId_shouldReturnAccountList() {
        when(accountRepository.findAll()).thenReturn(Arrays.asList(accountModel, accountModel));
        List<Account> accountList = accountService.getAll();
        assertNotNull(accountList);
    }
}
