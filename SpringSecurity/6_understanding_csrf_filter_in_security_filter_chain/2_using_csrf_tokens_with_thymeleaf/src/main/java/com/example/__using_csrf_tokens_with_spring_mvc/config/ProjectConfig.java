package com.example.__using_csrf_tokens_with_spring_mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetail = User.withUsername("John").password("12345").build();
        userDetailsManager.createUser(userDetail);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.formLogin(c -> c.defaultSuccessUrl("/main",true))
                .authorizeHttpRequests(c -> c.anyRequest().authenticated());
        return httpSecurity.build();
    }
}
