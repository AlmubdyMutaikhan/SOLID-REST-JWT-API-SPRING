package com.example.demo.excpetions;

public class AccountOperationDenied extends RuntimeException{
    public AccountOperationDenied(String id, double amount) {
        super(String.format("Account with ID=%s can't withdraw/deposit %f", id, amount));
    }
}
