package com.example.demo.interfaces;

import com.example.demo.classes.AccountWithdraw;

public interface AccountWithdrawService {
    public void deposit(double amount, AccountWithdraw accountWithdraw);
    public int withdraw(double amount, AccountWithdraw account);
}
