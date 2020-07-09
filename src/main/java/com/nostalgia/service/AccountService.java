package com.nostalgia.service;

import com.nostalgia.entity.Account;

public interface AccountService {
    public Account findByUserName(String userName);
}
