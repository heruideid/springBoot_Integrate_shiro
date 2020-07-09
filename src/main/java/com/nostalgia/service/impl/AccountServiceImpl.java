package com.nostalgia.service.impl;

import com.nostalgia.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nostalgia.repository.AccountRepository;
import com.nostalgia.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }
}
