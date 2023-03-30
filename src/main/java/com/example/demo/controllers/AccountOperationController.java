package com.example.demo.controllers;

import com.example.demo.classes.Account;
import com.example.demo.classes.Transaction;
import com.example.demo.classes.TransactionDeposit;
import com.example.demo.classes.TransactionWithdraw;
import com.example.demo.interfaces.AccountDepositService;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.AccountWithdrawService;
import com.example.demo.interfaces.TransactionListingService;
import com.example.demo.services.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AccountOperationController {
    @Autowired
    private TransactionDeposit transactionDeposit;
    @Autowired
    private AccountListingService accountListingService;
    @Autowired
    private TransactionWithdraw transactionWithdraw;
    private record Money(double amount){}
    private record ResMessage(String name, String desc) {}
    @Autowired
    private TransactionListingService transactionListingService;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/accounts/{id}/deposit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  ResMessage depositMoney(HttpServletRequest http,
                                    @PathVariable String id,
                                    @RequestBody Money money) {
        String username = tokenService.decodeToken(http);
        transactionDeposit.execute(accountListingService
                        .getClientWithdrawAccount(username, id),
                   money.amount());
            return new ResMessage("message", String.format("%f$ deposited to account id=%s", money.amount(),
                    id));
    }
    @PostMapping("/accounts/{id}/withdraw")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  ResMessage withdrawMoney(HttpServletRequest http, @PathVariable String id, @RequestBody Money money) {
        String username = tokenService.decodeToken(http);
        transactionWithdraw.execute(
                accountListingService.getClientWithdrawAccount(username, id),
                money.amount()
        );
        return new ResMessage("message", String.format("%f$ withdrew from account id=%s", money.amount(),
                id));
    }

    @GetMapping("/accounts/{id}/transactions")
    public List<Transaction> getTransactions(HttpServletRequest http, @PathVariable String id) {
        String username = tokenService.decodeToken(http);
        return transactionListingService.getTransactionByID(id);
    }



}
