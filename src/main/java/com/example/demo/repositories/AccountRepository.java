package com.example.demo.repositories;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.DatabaseMetaData;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {
    @Modifying
    @Query("INSERT INTO Account VALUES (:type, :id, :cid, :balance, :wa)")
    void createAccount(@Param("type") String accountType,
                              @Param("id")String id,
                              @Param("cid") String cid,
                              @Param("balance") double balance,
                              @Param("wa") boolean withdrawAllowed);
    @Query("SELECT * FROM Account WHERE ID=:id AND CLIENT_ID=:cid")
    Account findClientAccount(@Param("id") String id,
                                     @Param("cid") String cid);
    List<Account> findAccountsByClientID(String clientID);
    List<Account> findAccountsByClientIDAndAccountType(String clientID,
                                                       String accountType);
    @Modifying
    @Query("UPDATE Account A SET A.BALANCE=:amount WHERE A.ID=:aid")
    int updateBalance(@Param("amount") double amount,
                     @Param("aid") String aid);


}
