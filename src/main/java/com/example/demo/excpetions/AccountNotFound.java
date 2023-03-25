package com.example.demo.excpetions;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(String id) {
        super(String.format("Account with ID=%s has not found", id));
    }
}
