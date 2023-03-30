package com.example.demo.controllers.exceptions;

import com.example.demo.excpetions.TokenInvalid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TokenAdviceController {
    @ResponseBody
    @ExceptionHandler(TokenInvalid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String reportInvalidToken(TokenInvalid e) {
        return e.getMessage();
    }
}
