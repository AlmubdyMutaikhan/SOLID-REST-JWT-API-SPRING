package com.example.demo.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@ToString
public class Transaction {
    public Transaction(String date, String description) {
        this.date = date;
        this.description = description;
    }
    @Id
    private int id;
    private String  date;
    private String description;
}
