package com.example.demo.repositories;

import com.example.demo.entitiy.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);
}
