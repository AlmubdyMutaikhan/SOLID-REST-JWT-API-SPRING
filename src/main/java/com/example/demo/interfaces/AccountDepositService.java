package com.example.demo.interfaces;

import com.example.demo.classes.AccountWithdraw;

public interface AccountDepositService {
    public void deposit(double amount, AccountWithdraw accountWithdraw);
}
