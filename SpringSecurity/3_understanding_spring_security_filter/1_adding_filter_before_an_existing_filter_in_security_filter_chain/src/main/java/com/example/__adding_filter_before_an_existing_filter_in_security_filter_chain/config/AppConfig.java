package com.example.__adding_filter_before_an_existing_filter_in_security_filter_chain.config;


import com.example.__adding_filter_before_an_existing_filter_in_security_filter_chain.component.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("sai").password("12345").build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().permitAll());
        httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class);
        httpSecurity.httpBasic(Customizer.withDefaults());
        //httpSecurity.formLogin(c -> c.configure(httpSecurity));
        return httpSecurity.build();
    }
}
