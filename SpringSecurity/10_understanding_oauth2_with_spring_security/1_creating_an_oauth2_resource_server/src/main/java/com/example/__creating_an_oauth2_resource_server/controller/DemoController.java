package com.example.__creating_an_oauth2_resource_server.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String helloController(){

        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
