package com.example.demo.controllers.exceptions;


import com.example.demo.excpetions.AccountNotFound;
import com.example.demo.excpetions.AccountOperationDenied;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AccountControllerAdvice {
    @ResponseBody
    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String accountNotFound(AccountNotFound e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AccountOperationDenied.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String accountOperationDenied(AccountOperationDenied e) {
        return e.getMessage();
    }
}
