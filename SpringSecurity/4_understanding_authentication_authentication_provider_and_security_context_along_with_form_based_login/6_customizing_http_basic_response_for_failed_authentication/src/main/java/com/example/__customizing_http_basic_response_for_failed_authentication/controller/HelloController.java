package com.example.__customizing_http_basic_response_for_failed_authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloController(){
        return "Hello there";
    }
}
