package com.example.__adding_filter_before_an_existing_filter_in_security_filter_chain.config;

import com.example.__adding_filter_before_an_existing_filter_in_security_filter_chain.component.StaticKeyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {

    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    public AppConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter){
        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeHttpRequests(c -> c.anyRequest().permitAll())
                .addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class);
        return httpSecurity.build();

    }

}
