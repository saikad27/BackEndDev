package com.example.__using_request_matchers_to_configure_authorization.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao!";
    }

    @GetMapping("/hola")
    public String hola(){
        return "Hola!";
    }

}
