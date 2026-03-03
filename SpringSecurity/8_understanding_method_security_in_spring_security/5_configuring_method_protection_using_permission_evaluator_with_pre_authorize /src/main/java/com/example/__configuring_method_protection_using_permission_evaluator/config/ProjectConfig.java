package com.example.__configuring_method_protection_using_permission_evaluator.config;


import com.example.__configuring_method_protection_using_permission_evaluator.method_security.component.DocumentPermissionEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class ProjectConfig {

    private final DocumentPermissionEvaluator permissionEvaluator;

    public ProjectConfig(DocumentPermissionEvaluator permissionEvaluator){
        this.permissionEvaluator = permissionEvaluator;
    }

    @Bean
    public MethodSecurityExpressionHandler methodSecurityExpressionHandler(){
        DefaultMethodSecurityExpressionHandler methodSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();
        methodSecurityExpressionHandler.setPermissionEvaluator(permissionEvaluator);
        return methodSecurityExpressionHandler;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("emma").password("12345").roles("MANAGER").build();
        UserDetails user2 = User.withUsername("natalie").password("12345").roles("ADMIN").build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
