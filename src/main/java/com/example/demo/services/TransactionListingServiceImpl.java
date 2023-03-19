package com.example.demo.services;

import com.example.demo.classes.Transaction;
import com.example.demo.interfaces.TransactionDAO;
import com.example.demo.interfaces.TransactionListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TransactionListingServiceImpl implements TransactionListingService {


    private final TransactionDAO transactionDAO;
    @Autowired
    public TransactionListingServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionDAO.getTransactions();
    }

    public void showAllTransactions() {
        for(var transaction : transactionDAO.getTransactions()){
            System.out.println(transaction);
        }
    }
    @Override
    public Transaction getTransactionByID(String UUID) {
        for(var transaction : transactionDAO.getTransactions()){
            if(transaction.getDate().equals(UUID)){
                return transaction;
            }
        }
        return null;
    }
}
