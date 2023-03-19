package com.example.demo.classes;

import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountType;
import com.example.demo.classes.AccountWithdraw;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList;

    public List<Account> getAccountList() {
        return accountList;
    }

    public MemoryAccountDAO() {
        accountList = new ArrayList<>();
    }
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> clientAccounts = new ArrayList<>();

        for(var account : accountList) {
            if(account.getClientID().equals(clientID)){
                clientAccounts.add(account);
            }
        }

        return clientAccounts;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account updatedAccount) {
        Account removingAccount = null;
        for(var account : accountList) {
            if (account.getId().equals(updatedAccount.getId())) {
                removingAccount = account;
                break;
            }
        }

        accountList.remove(removingAccount);
        accountList.add(updatedAccount);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> accountsByType = new ArrayList<>();

        for(var account : accountList) {
            if(account.getClientID().equals(clientID)  && account.getAccountType() == accountType) {
                accountsByType.add(account);
            }

        }

        return accountsByType;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {

        for(var account : accountList) {
            if(account.getClientID().equals(clientID)  &&
                    (account.getAccountType() == AccountType.CHECKING ||
                            account.getAccountType() == AccountType.SAVING)
                    && account.getId().equals(accountID)){
                return (AccountWithdraw) account;
            }

        }
        return null;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for(var account : accountList) {
            if(account.getClientID().equals(clientID)
                    && account.getId().equals(accountID)){
                return account;
            }
        }

        return null;
    }
}
