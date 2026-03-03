package com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.config;

import com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.component.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SecurityConfig {
    private final CustomCsrfTokenRepository csrfTokenRepository;
    public SecurityConfig(CustomCsrfTokenRepository csrfTokenRepository){
        System.out.println("Injecting CustomCsrfTokenRepository");
        this.csrfTokenRepository = csrfTokenRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        System.out.println("Configuring Security");
        httpSecurity
                .csrf(c -> c
                        .csrfTokenRepository(csrfTokenRepository)
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                )
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return httpSecurity.build();
    }
}
