package com.example.demo.services;

import com.example.demo.classes.Account;
import com.example.demo.classes.Transaction;
import com.example.demo.excpetions.AccountNotFound;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.TransactionDAO;
import com.example.demo.interfaces.TransactionListingService;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TransactionListingServiceImpl implements TransactionListingService {

    @Autowired
    private AccountListingService accountListingService;
    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionListingServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public void showAllTransactions() {
        for(var transaction : transactionRepository.findAll()){
            System.out.println(transaction);
        }
    }
    @Override
    public List<Transaction> getTransactionByID(String UUID) {
       Account account = accountListingService.getClientAccount("1", UUID);

       return transactionRepository.findTransactionsByAccountID(account.getId());
    }
}
