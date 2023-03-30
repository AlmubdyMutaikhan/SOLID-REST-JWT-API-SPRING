package com.example.demo.entitiy;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Client {
    public Client(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
    @Id
    private int id;

    private String username;

    private String pwd;


}
