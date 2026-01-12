package com.example.__restricting_access_to_endpoints_using_authorities.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        String expression = "hasAuthority('READ') && !hasAuthority('DELETE')";
        httpSecurity
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c -> c.anyRequest().access(new WebExpressionAuthorizationManager(expression)));
        return httpSecurity.build();
    }
}
