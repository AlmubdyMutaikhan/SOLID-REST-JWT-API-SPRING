package com.example.demo.classes;

import com.example.demo.interfaces.AccountDepositService;
import com.example.demo.interfaces.TransactionDAO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@Getter
public class TransactionDeposit {

    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
            this.accountDepositService = accountDepositService;
            this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double balance) {
        accountDepositService.deposit(balance, accountWithdraw);
        String log = String.format("OK : %.2f$ has been deposited", balance);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        transactionDAO.addTransaction(new Transaction(dtf.format(now),log));
    }
}
