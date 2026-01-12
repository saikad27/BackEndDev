package com.example.__customizing_http_basic_response_for_failed_authentication.config;

import com.example.__customizing_http_basic_response_for_failed_authentication.security_components.CustomEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .formLogin(Customizer.withDefaults())
                .httpBasic(c -> c.realmName("OTHER").authenticationEntryPoint(new CustomEntryPoint()))
                .authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return httpSecurity.build();
    }
}
