package com.example.demo.entitiy;


import com.example.demo.classes.Account;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Set;

@Data
public class Client {
    public Client(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
    @Id
    private String username;

    private String pwd;
    @MappedCollection(idColumn = "CLIENT_ID", keyColumn = "CLIENT_ID")
    private Set<Account> accountList;


}
