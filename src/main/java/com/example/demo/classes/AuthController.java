package com.example.demo.classes;

import com.example.demo.controllers.ClientController.ClientRequest;
import com.example.demo.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    TokenService tokenService;
    @GetMapping("/authenticate")
    public String signClient(Authentication authentication) {
        System.out.println("hello world");
        String username = authentication.getName();
        String token = tokenService.generateToken(authentication);
        return token;
    }
}
