package com.example.__making_a_cross_origin_call.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .cors(c -> {
                    CorsConfigurationSource source = request -> {
                        CorsConfiguration corsConfig = new CorsConfiguration();
                        corsConfig.setAllowedOrigins(List.of("http://localhost:8000"));
                        corsConfig.setAllowedMethods(List.of("GET","POST"));
                        corsConfig.setAllowedHeaders(List.of("*"));
                        return corsConfig;
                    };
                    c.configurationSource(source);
                })
                .csrf( c -> c.disable())
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return httpSecurity.build();
    }

}
