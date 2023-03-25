package com.example.demo.controllers;

import com.example.demo.classes.Account;
import com.example.demo.classes.BankCore;
import com.example.demo.interfaces.AccountCreationService;
import com.example.demo.interfaces.AccountListingService;
import com.example.demo.interfaces.AccountType;
import com.example.demo.services.AccountRemovingServiceImpl;
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

    @GetMapping("")
    @ResponseBody
    public List<Account> getAllAccounts() {
        return accountListingService.getClientAccounts("1");
    }

    @GetMapping("/{accounts_id}")
    public Account getAccountById(@PathVariable String accounts_id) {
        return accountListingService.getClientAccount("1", accounts_id);
    }
    private record ResMessage(String name, String desc) {}
    private record AccountCreationType(String accountType){}
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResMessage createAccount(@RequestBody AccountCreationType accountType) {
        AccountType accountType1 = AccountType.SAVING;

        try {
            accountType1 = AccountType.valueOf(accountType.accountType());
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong account type is indicated. Set default by SAVING");
        }

        bankCore.createNewAccount(accountType1, "1");
        return new ResMessage("status", "ok");
    }

    @DeleteMapping("/{accounts_id}")
    public ResMessage destroyAccountById(@PathVariable String accounts_id) {
        accountRemovingService.destroyAccountById(accounts_id);
        return new ResMessage("resMessage", ("Successfully deleted account id=" + accounts_id));
    }




}
