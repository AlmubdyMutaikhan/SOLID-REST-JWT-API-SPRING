package com.example.demo.classes;

import com.example.demo.excpetions.AccountOperationDenied;
import com.example.demo.interfaces.AccountWithdrawService;
import com.example.demo.interfaces.TransactionDAO;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
@Component
public class TransactionWithdraw {
    private static final Logger LOGGER = Logger.getLogger(TransactionWithdraw.class.getName());
    private final AccountWithdrawService accountWithdrawService;
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionWithdraw(AccountWithdrawService accountWithdrawService,
                               TransactionRepository transactionRepository){
        this.accountWithdrawService = accountWithdrawService;
        this.transactionRepository = transactionRepository;
    }

    public void execute(AccountWithdraw accountWithdraw, double balance) {
        int statusCode = accountWithdrawService.withdraw(balance, accountWithdraw);
        if(statusCode == -1) {
            throw new AccountOperationDenied(accountWithdraw.getId(), balance);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String log = String.format("OK : %.2f$ has been withdrew", balance);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(log);
        System.out.println(transactionRepository.save(new Transaction(dtf.format(now), log, accountWithdraw.getId())));
    }
}
