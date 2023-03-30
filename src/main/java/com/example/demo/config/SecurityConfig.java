package com.example.demo.config;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        return encoder;
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests()
                .requestMatchers("/v3/api-docs/**", "/client/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // разрешить доступ всем
                .requestMatchers("/authenticate").authenticated() // любой запрос требует авторизации
                .and()
                .httpBasic() // Basic аутентификация
                .and()
                .csrf().disable() // Отключаем csrf токены
                .build();
    }
    String jwtKey = "secretss3248932wefjnewdsfjasd.fmvndsl.fcmaslz.vknsald/qwma;'fwedsaflkdas";
    @Bean
    JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        byte[] bytes = jwtKey.getBytes();
        SecretKeySpec originalKey = new SecretKeySpec(bytes, 0, bytes.length,"RSA");
        return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS512).build();
    }
}
