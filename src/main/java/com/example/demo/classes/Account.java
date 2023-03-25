package com.example.demo.classes;


import com.example.demo.interfaces.AccountType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Account {
    public Account(){}
    public Account(AccountType accountType,
                   String id,
                   String clientID,
                   double balance,
                   boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }
    private AccountType accountType;
    @Id
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
    @MappedCollection(keyColumn = "ACCOUNT_ID", idColumn = "ACCOUNT_ID")
    private Set<Transaction> transactionSet;
}
