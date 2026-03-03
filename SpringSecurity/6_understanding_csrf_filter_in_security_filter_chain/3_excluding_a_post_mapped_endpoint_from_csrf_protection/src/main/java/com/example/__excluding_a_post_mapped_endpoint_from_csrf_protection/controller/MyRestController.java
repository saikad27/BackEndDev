package com.example.__excluding_a_post_mapped_endpoint_from_csrf_protection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @PostMapping("/hello")
    public String hello(){
        return "Post hello";
    }

    @PostMapping("/ciao")
    public String ciao(){
        return "Post Ciao";
    }
}
