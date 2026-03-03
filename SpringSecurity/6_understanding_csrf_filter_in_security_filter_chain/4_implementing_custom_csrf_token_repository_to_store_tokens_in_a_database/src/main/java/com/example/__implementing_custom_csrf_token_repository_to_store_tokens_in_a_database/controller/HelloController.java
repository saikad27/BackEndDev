package com.example.__implementing_custom_csrf_token_repository_to_store_tokens_in_a_database.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloGet(){
        return "Hello get";
    }
    @PostMapping("/hello")
    public String helloPost(){
        return "Hello post";
    }
}
