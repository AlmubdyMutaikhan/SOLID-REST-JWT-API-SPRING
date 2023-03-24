package com.example.demo.classes;


import com.example.demo.interfaces.AccountType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Account {
    public Account(){}
    private AccountType accountType;
    @Id
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;

}
