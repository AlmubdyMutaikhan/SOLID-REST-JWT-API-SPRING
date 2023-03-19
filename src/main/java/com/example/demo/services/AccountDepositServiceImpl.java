package com.example.demo.services;

import com.example.demo.classes.AccountWithdraw;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    private final AccountDAO accountDAO;
    private static final Logger logger = Logger.getLogger(AccountDepositService.class.getName());
    @Autowired
    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    public void deposit(double amount, AccountWithdraw accountWithdraw) {
        if(accountWithdraw != null){
            boolean isDepositAccepted = amount > 0;
            if(isDepositAccepted){
                accountWithdraw.setBalance(accountWithdraw.getBalance() + amount);
                logger.log(Level.INFO, String.format("Successfully transferred %.2f$ to account(ID=%s)",
                        amount,
                        accountWithdraw.getClientID()));
            }
        } else {
            logger.log(Level.WARNING, "NOK : Withdraw isn't allowed");
        }


    }
}
