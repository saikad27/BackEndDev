package com.example.__first_spring_security_project.component;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Override
    public Authentication authenticate(Authentication authentication){
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if("sai".equals(username) && "12345".equals(password)){
            return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
        }else{
            throw new AuthenticationCredentialsNotFoundException("Error");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationProvider){
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationProvider);
    }
}
