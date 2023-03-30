package com.example.demo.repositories;

import com.example.demo.entitiy.Client;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client, Integer> {
    @Modifying
    @Query("INSERT INTO Client VALUES (:username, :pwd)")
    void createClient(@Param("username") String username,
                       @Param("pwd")String pwd);
    Optional<Client> findByUsername(String username);
}
