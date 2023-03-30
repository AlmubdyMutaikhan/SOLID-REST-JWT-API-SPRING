package com.example.demo.services;

import com.example.demo.excpetions.TokenInvalid;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private final JwtEncoder encoder;
 private final static String SECRET_KEY = "secretss3248932wefjnewdsfjasd.fmvndsl.fcmaslz.vknsald/qwma;'fwedsaflkdas";
    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String decodeToken(HttpServletRequest http) {

        try {
            String token = http.getHeader("authorization");

            if(token == null){throw new TokenInvalid("Token doesn't exist");}
            token =  token.substring(7);
            String[] chunks = token.split("\\.");
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String payload = new String(decoder.decode(chunks[1]));
            payload = payload.split(",")[1].split(":")[1];
            payload = payload.substring(1, payload.length() - 1);
            return payload;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TokenInvalid(e.getMessage());
        }
    }



    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", "BANK CLIENT").build();
        var encoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(), claims);
        return this.encoder.encode(encoderParameters).getTokenValue();
    }

}