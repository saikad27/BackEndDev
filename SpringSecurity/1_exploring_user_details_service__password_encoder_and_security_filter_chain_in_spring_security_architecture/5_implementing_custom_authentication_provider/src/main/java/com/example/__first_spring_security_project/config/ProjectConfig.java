package com.example.__first_spring_security_project.config;

import com.example.__first_spring_security_project.component.CustomAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.Customizer;

@Configuration
public class ProjectConfig{

    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider){
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().authenticated());
        httpSecurity.authenticationProvider(authenticationProvider);
        return httpSecurity.build();
    }

}
