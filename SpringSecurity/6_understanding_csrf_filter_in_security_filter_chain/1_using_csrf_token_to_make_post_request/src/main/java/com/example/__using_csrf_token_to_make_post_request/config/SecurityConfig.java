package com.example.__using_csrf_token_to_make_post_request.config;

import com.example.__using_csrf_token_to_make_post_request.filter.CsrfTokenLoggerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class)
                .authorizeHttpRequests(c -> c
                        .anyRequest().permitAll()
                );
        return httpSecurity.build();
    }
}
