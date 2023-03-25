package com.example.demo.cli;

import com.example.demo.classes.Transaction;
import com.example.demo.interfaces.TransactionListingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TransactionBasicCLI {

    @Autowired
    private TransactionListingService transactionListingService;

    public void showAllTransactions() {
        transactionListingService.showAllTransactions();
    }

    public List<Transaction> getTransactionList() {
        return transactionListingService.getAllTransactions();
    }

    public List<Transaction> getByID(String UUID) {
        return transactionListingService.getTransactionByID(UUID);
    }

}
