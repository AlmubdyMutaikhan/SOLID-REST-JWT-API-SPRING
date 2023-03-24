package com.example.demo.classes;

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
        accountWithdrawService.withdraw(balance, accountWithdraw);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String log = String.format("OK : %.2f$ has been withdrew", balance);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(log);
        transactionRepository.save(new Transaction(dtf.format(now), log));
    }
}
