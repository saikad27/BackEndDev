package com.example.__using_csrf_token_to_make_post_request.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @GetMapping("/hello")
    public String postHello(){
        return "Hello GET";
    }

    @PostMapping("/hello")
    public String getHello(){
        return "Hello POST";
    }
}
