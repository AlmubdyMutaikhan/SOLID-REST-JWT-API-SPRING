package com.example.demo.interfaces;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;

import java.util.List;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientID);
    public void createNewAccount(Account account);
    public void updateAccount(Account account);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public Account getClientAccount(String clientID, String accountID);
}
