package com.example.__filtering_return_value_of_a_method_using_post_filtering.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableMethodSecurity
@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("Nicolai").password("12345").authorities("READ").build();
        UserDetails user2 = User.withUsername("Julien").password("12345").authorities("WRITE").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
