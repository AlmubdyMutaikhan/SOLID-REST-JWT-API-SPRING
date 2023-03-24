package com.example.demo.repositories;

import com.example.demo.classes.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<
        Transaction, Integer> {
}
