package com.example.demo.cli;

import com.example.demo.classes.AccountWithdraw;
import com.example.demo.classes.TransactionDeposit;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.WithdrawDepositCLIUI;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TransactionDepositCLI {
    static Logger logger = Logger.getLogger(TransactionDeposit.class.getName());
    private final TransactionDeposit transactionDeposit;
    private final WithdrawDepositCLIUI withdrawDepositCLIUI;
    private final AccountListingService accountListingService;

    @Autowired
    private MyCLI myCLI;
    @Autowired
    public TransactionDepositCLI(TransactionDeposit transactionDeposit,
                                 WithdrawDepositCLIUI withdrawDepositCLIUI,
                                 AccountListingService accountListingService) {
            this.accountListingService = accountListingService;
            this.withdrawDepositCLIUI = withdrawDepositCLIUI;
            this.transactionDeposit = transactionDeposit;
    }
    public void depositMoney(String clientID) {
       String accountID = withdrawDepositCLIUI.requestClientAccountNumber();
       double amount = withdrawDepositCLIUI.requestClientAmount();
       transactionDeposit.execute((AccountWithdraw) accountListingService.getClientWithdrawAccount(clientID, accountID),
               amount);
    }
}
