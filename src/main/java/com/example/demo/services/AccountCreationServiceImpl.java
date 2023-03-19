package com.example.demo.services;

import com.example.demo.classes.Account;
import com.example.demo.classes.AccountWithdraw;
import com.example.demo.interfaces.AccountCreationService;
import com.example.demo.interfaces.AccountDAO;
import com.example.demo.interfaces.AccountType;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

    private final AccountDAO accountDAO;
    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        boolean withdrawAllowed = !accountType.equals(AccountType.FIXED);
        Account account = null;
        if(withdrawAllowed) {
            account = new AccountWithdraw(accountType,
                    String.format("%03d%06d", 1, accountID),
                    clientID, 0, true);
        } else {
            account = new Account(accountType,
                    Long.toString(accountID),
                    clientID, 0, false);
        }
        accountDAO.createNewAccount(account);
    }
}
