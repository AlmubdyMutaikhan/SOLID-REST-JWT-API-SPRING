package com.example.demo.services;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountDepositService;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    private final AccountRepository accountRepository;
    private static final Logger logger = Logger.getLogger(AccountDepositService.class.getName());
    @Autowired
    public AccountDepositServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public int deposit(double amount, AccountWithdraw accountWithdraw) {
        if(accountWithdraw != null){
            boolean isDepositAccepted = amount > 0;
            if(isDepositAccepted){
                accountWithdraw.setBalance(accountWithdraw.getBalance() + amount);
                int a = accountRepository.updateBalance(accountWithdraw.getBalance(), accountWithdraw.getId());
                return a != 0 ? 0 : -1;
            }
        } else {
            logger.log(Level.WARNING, "NOK : Withdraw isn't allowed");
            return -1;
        }
        return  -1;
    }
}
