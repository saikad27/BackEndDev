package com.example.__configuring_preauthorization_for_a_method_call.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('WRITE')")
    public String getName(){
        return "Fantastico";
    }
}
