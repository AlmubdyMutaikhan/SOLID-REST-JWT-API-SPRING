package com.example.demo.services;

import com.example.demo.classes.Transaction;
import com.example.demo.interfaces.TransactionDAO;
import com.example.demo.interfaces.TransactionListingService;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TransactionListingServiceImpl implements TransactionListingService {


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
    public Transaction getTransactionByID(String UUID) {
       /* for(var transaction : transactionDAO.getTransactions()){
            if(transaction.getDate().equals(UUID)){
                return transaction;
            }
        }*/
        return null;
    }
}
