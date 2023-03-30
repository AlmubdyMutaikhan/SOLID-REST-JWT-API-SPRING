package com.example.demo.controllers;

import com.example.demo.entitiy.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    public record ClientRequest(String username, String pwd){}
    @Autowired
    ClientRepository clientRepository;
    @PostMapping("/new")
    public String createNewClient(@RequestBody ClientRequest client) {
        clientRepository.createClient(client.username(), client.pwd());
        return "user created";
    }

    @GetMapping("/all")
    public List<Client> getAll() {
        return (List<Client>) clientRepository.findAll();
    }
}
