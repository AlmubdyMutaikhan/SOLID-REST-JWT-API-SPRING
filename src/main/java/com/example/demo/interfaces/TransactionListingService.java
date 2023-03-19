package com.example.demo.interfaces;

import com.example.demo.classes.Transaction;

import java.util.List;

public interface TransactionListingService {
    public List<Transaction> getAllTransactions();
    public Transaction getTransactionByID(String UUID);
    public void showAllTransactions();
}
