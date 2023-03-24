package com.example.demo.cli;

import com.example.demo.classes.AccountWithdraw;
import com.example.demo.classes.TransactionWithdraw;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.WithdrawDepositCLIUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositCLIUI withdrawDepositCLIUI;
    private AccountListingService accountListingService;
    @Autowired
    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositCLIUI withdrawDepositCLIUI,
                                  AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositCLIUI = withdrawDepositCLIUI;
        this.accountListingService = accountListingService;
    }

    public void withdrawMoney(String clientID) {
       String accountID = withdrawDepositCLIUI.requestClientAccountNumber();
       double amount = withdrawDepositCLIUI.requestClientAmount();
       transactionWithdraw.execute(
              accountListingService.getClientWithdrawAccount(clientID, accountID),
               amount
       );



    }

}
