package com.example.demo.services;

import com.example.demo.classes.JWTClientDetails;
import com.example.demo.entitiy.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class JWTUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Client> client = clientRepository.findByUsername(username);
        System.out.println(client);
       if(client.isEmpty()) {
           throw new UsernameNotFoundException("not found username : "+username);
       }
       return new JWTClientDetails(client.get().getUsername(), "{noop}"+client.get().getPwd());
    }
}
