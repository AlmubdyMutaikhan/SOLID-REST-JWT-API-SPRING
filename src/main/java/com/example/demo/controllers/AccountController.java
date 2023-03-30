package com.example.demo.controllers;

import com.example.demo.classes.Account;
import com.example.demo.classes.BankCore;
import com.example.demo.interfaces.AccountCreationService;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.AccountType;
import com.example.demo.services.AccountRemovingServiceImpl;
import com.example.demo.services.TokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountListingService accountListingService;
    @Autowired
    private BankCore bankCore;
    @Autowired
    private AccountRemovingServiceImpl accountRemovingService;
    @Autowired
    private TokenService tokenService;
    @GetMapping("")
    @ResponseBody
    public List<Account> getAllAccounts(HttpServletRequest http) {

        //{"iss":"self","sub":"ali","exp":1680164355,"iat":1680160755,"scope":"BANK CLIENT"}
        String username = tokenService.decodeToken(http);
        return accountListingService.getClientAccounts(username);
    }

    @GetMapping("/{accounts_id}")
    public Account getAccountById(HttpServletRequest http, @PathVariable String accounts_id) {
        String token = http.getHeader("authorization").substring(7);
        //{"iss":"self","sub":"ali","exp":1680164355,"iat":1680160755,"scope":"BANK CLIENT"}
        String username = tokenService.decodeToken(http);
        return accountListingService.getClientAccount(username, accounts_id);
    }
    private record ResMessage(String name, String desc) {}
    private record AccountCreationType(String accountType){}
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResMessage createAccount(HttpServletRequest http, @RequestBody AccountCreationType accountType) {
        AccountType accountType1 = AccountType.SAVING;
        String token = http.getHeader("authorization").substring(7);
        //{"iss":"self","sub":"ali","exp":1680164355,"iat":1680160755,"scope":"BANK CLIENT"}
        String username = tokenService.decodeToken(http);
        try {

            accountType1 = AccountType.valueOf(accountType.accountType());
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong account type is indicated. Set default by SAVING");
        }

        bankCore.createNewAccount(accountType1, username);
        return new ResMessage("status", "ok");
    }

    @DeleteMapping("/{accounts_id}")
    public ResMessage destroyAccountById(HttpServletRequest http, @PathVariable String accounts_id) {
        String token = http.getHeader("authorization").substring(7);
        //{"iss":"self","sub":"ali","exp":1680164355,"iat":1680160755,"scope":"BANK CLIENT"}
        String username = tokenService.decodeToken(http);
        accountRemovingService.destroyAccountById(accounts_id);
        return new ResMessage("resMessage", ("Successfully deleted account id=" + accounts_id));
    }




}
