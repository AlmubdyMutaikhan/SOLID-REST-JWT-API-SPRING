package com.example.demo.repositories;

import com.example.demo.classes.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TransactionRepository extends CrudRepository<
        Transaction, Integer> {

    @Query("SELECT * FROM Transaction WHERE ACCOUNT_ID=:account_id")
    List<Transaction> findTransactionsByAccountID(@Param("account_id") String account_id);
}
