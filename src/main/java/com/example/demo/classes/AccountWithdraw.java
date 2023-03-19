package com.example.demo.classes;

import com.example.demo.interfaces.AccountType;

public class AccountWithdraw extends Account{
    public AccountWithdraw(){

    }
    public AccountWithdraw(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
