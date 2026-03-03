package com.example.__excluding_a_post_mapped_endpoint_from_csrf_protection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .csrf( c -> c.ignoringRequestMatchers("/ciao"))
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return httpSecurity.build();
    }
}
