package com.nostalgia.service.impl;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.nostalgia.service.AccountService;


@SpringBootTest
class AccountServiceImplTest {
    @Autowired
    AccountService accountService;

    @Test
    void test1(){
        System.out.println(accountService.findByUserName("ls"));
        System.out.println(accountService.findByUserName("zs"));
        System.out.println(accountService.findByUserName("ww"));
    }
}