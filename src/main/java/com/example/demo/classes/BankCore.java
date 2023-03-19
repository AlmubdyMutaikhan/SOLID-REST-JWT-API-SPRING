package com.example.demo.classes;

import com.example.demo.interfaces.AccountCreationService;
import com.example.demo.interfaces.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountID = 1;
    private final AccountCreationService accountCreationService;


    @Autowired
    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreationService.create(accountType, id, clientID, lastAccountID);
        IncrementLastAccountNumber();
    }

    public void IncrementLastAccountNumber() {
        id += 1;
        lastAccountID += 1;
    }

}