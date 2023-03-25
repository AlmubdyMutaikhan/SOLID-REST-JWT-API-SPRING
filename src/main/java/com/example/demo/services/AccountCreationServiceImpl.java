package com.example.demo.services;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;
import com.example.demo.interfaces.AccountCreationService;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountType;
import com.example.demo.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean withdrawAllowed = !accountType.equals(AccountType.FIXED);
        Account account = null;
        if(withdrawAllowed) {
            account = new Account(accountType,
                    String.format("%03d%06d", 1, accountID),
                    clientID, 0, true);
        } else {
            account = new Account(accountType,
                    String.format("%03d%06d", 1, accountID),
                    clientID, 0, false);
        }
        accountRepository.createAccount(account.getAccountType().toString(),
                account.getId(),
                account.getClientID(),
                account.getBalance(),
                account.isWithdrawAllowed());;
    }
}
