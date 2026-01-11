package com.example.__using_request_matchers_to_configure_authorization.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .httpBasic(Customizer.withDefaults())
                .csrf(c -> c.disable())
                .authorizeHttpRequests(
                        c -> c
                                .requestMatchers(HttpMethod.GET,"/a").authenticated()
                                .requestMatchers(HttpMethod.POST,"/a").permitAll()
                                .anyRequest().denyAll()
                );
        return httpSecurity.build();
    }
}
