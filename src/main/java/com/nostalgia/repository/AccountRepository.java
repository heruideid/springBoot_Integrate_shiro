package com.nostalgia.repository;

import com.nostalgia.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    public Account findAccountByUserName(String userName);
}
