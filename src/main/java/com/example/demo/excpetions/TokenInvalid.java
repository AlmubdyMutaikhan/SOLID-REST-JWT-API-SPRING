package com.example.demo.excpetions;

public class TokenInvalid extends RuntimeException{
    public TokenInvalid(String msg) {
        super(msg);
    }
}
