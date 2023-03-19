package com.example.demo.services;

import com.example.demo.classes.AccountWithdraw;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;
    @Autowired
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        boolean isWithdrawAccepted = amount > 0 && (account.getBalance() - amount) >= 0.0;
        if(isWithdrawAccepted) {
            account.setBalance(account.getBalance() - amount);
        } else {
            System.out.println("ERROR: Not enough money or invalid money value");
        }
    }

    @Override
    public void deposit(double amount, AccountWithdraw accountWithdraw) {
        boolean isDepositAccepted = amount > 0;
        if(isDepositAccepted){
            accountWithdraw.setBalance(accountWithdraw.getBalance() + amount);
        }

    }
}
