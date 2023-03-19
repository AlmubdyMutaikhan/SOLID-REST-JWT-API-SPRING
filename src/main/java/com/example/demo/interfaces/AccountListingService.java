package com.example.demo.interfaces;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount(String clientID, String accountID);
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    public List<Account> getClientAccounts(String clientID);
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);

}
