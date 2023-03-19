package com.example.demo.cli;

import com.example.demo.classes.Account;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.CreateAccountOperationUI;
import com.example.demo.classes.BankCore;
import com.example.demo.interfaces.AccountType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class AccountBasicCLI {
    private final CreateAccountOperationUI createAccountOperationUI;
    private final AccountListingService accountListingService;
    private final BankCore bankCore;
    private static Logger logger;
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore,
                           AccountListingService accountListingService) {
        this.createAccountOperationUI = new MyCLI();
        logger = Logger.getLogger(AccountBasicCLI.class.getName());
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void createAccountRequest(String clientID) {
        System.out.print("Choose account type: ");
        AccountType accountType = createAccountOperationUI.requestAccountType();
        bankCore.createNewAccount(accountType, clientID);
        logger.log(Level.INFO, String.format("OK : Account %s creation ", accountType));
    }

    public void getAccounts(String clientID) {
        List<Account> accountsList = accountListingService.getClientAccounts(clientID);
        if(accountsList.size() == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[");
            for (var account : accountsList) {
                System.out.println(account);
            }
            System.out.println("]");
            logger.log(Level.INFO, String.format("OK : Accounts have been shown "));
        }
    }
}
