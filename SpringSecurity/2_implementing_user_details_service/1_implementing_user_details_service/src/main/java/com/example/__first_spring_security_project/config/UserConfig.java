package com.example.__first_spring_security_project.config;


import com.example.__first_spring_security_project.model.User;
import com.example.__first_spring_security_project.service.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = new User("john","12345","read");
        List<UserDetails> userDetailsList = List.of(user);
        return new InMemoryUserDetailsService(userDetailsList);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
