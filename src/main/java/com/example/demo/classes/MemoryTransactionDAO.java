package com.example.demo.classes;

import com.example.demo.interfaces.TransactionDAO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    private List<Transaction> transactions;
    MemoryTransactionDAO() {
        transactions = new ArrayList<>();
    }
    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
