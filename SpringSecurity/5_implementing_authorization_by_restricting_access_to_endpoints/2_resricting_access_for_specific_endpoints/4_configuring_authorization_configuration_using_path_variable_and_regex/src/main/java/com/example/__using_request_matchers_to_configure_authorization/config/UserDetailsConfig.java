package com.example.__using_request_matchers_to_configure_authorization.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;

@Controller
public class UserDetailsConfig {
    private final PasswordEncoder passwordEncoder;
    public UserDetailsConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    public UserDetailsService userDetailsService(){
        String password = passwordEncoder.encode("12345");
        UserDetails user1 = User.withUsername("John").password(password).roles("ADMIN").build();
        UserDetails user2 = User.withUsername("Jane").password(password).roles("MANAGER").build();
        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        return userDetailsManager;
    }

}
