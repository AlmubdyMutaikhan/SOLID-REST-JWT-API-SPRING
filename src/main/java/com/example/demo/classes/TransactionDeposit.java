package com.example.demo.classes;

import com.example.demo.excpetions.AccountOperationDenied;
import com.example.demo.interfaces.AccountDepositService;
import com.example.demo.interfaces.TransactionDAO;
import com.example.demo.repositories.TransactionRepository;
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
    private TransactionRepository transactionRepository;


    @Autowired
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionRepository transactionRepository) {
            this.accountDepositService = accountDepositService;
            this.transactionRepository = transactionRepository;
    }

    public void execute(AccountWithdraw accountWithdraw, double balance) {
        int statusCode = accountDepositService.deposit(balance, accountWithdraw);
        if(statusCode == -1) { throw  new AccountOperationDenied(accountWithdraw.getId(), balance);
        }
        String log = String.format("OK : %.2f$ has been deposited", balance);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        transactionRepository.save(new Transaction(dtf.format(now),log, accountWithdraw.getId()));
    }
}
