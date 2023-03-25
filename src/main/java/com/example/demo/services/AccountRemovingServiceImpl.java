package com.example.demo.services;

import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountRemovingServiceImpl {
    @Autowired
    AccountRepository accountRepository;

    public void destroyAccountById(String aid) {
        System.out.println(accountRepository.deleteAccountById(aid));
    }



}
