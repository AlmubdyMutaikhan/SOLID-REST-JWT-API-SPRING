package com.example.demo.interfaces;

import com.example.demo.classes.Transaction;

import java.util.List;
import java.util.Set;

public interface TransactionListingService {
    public List<Transaction> getAllTransactions();
    public List<Transaction> getTransactionByID(String UUID);
    public void showAllTransactions();
}
