package com.example.demo.interfaces;

import com.example.demo.classes.AccountWithdraw;

public interface AccountDepositService {
    public int deposit(double amount, AccountWithdraw accountWithdraw);
}
