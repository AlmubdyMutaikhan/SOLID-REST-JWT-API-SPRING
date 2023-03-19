package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Greeting {
    @Value("${message}")
    private String message;
    public void sayHello() {
        System.out.println(this.message);
    }
}
