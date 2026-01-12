package com.example.__implementing_authentication_provider_for_applying_custom_authentication_logic.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

 @ResponseBody
    @GetMapping("/hello")
    public String helloController(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication= context.getAuthentication();
        return "Hello "+authentication.getName();
    }

    @ResponseBody
    @GetMapping("/hello_again")
    public String helloAgainController(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication= context.getAuthentication();
        return "Hello again "+authentication.getName();
    }
}
