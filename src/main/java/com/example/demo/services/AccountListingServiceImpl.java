package com.example.demo.services;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;
import com.example.demo.excpetions.AccountNotFound;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.AccountType;
import com.example.demo.repositories.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class AccountListingServiceImpl implements AccountListingService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getClientAccount(String clientID, String accountID) {
       Account account = accountRepository.findClientAccount(accountID, clientID);
        if(account == null) {
            throw new AccountNotFound(accountID);
        } else {
            return account;
        }
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        Account account =  accountRepository.findClientAccount(accountID, clientID);
        if(account == null) {
            throw new AccountNotFound(accountID);
        } else {
            return new AccountWithdraw(
                    account.getAccountType(),
                    account.getId(),
                    account.getClientID(),
                    account.getBalance(),
                    account.isWithdrawAllowed()
            );
        }

    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountRepository.findAccountsByClientID(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.findAccountsByClientIDAndAccountType(clientID,
                accountType.toString());
    }
}
