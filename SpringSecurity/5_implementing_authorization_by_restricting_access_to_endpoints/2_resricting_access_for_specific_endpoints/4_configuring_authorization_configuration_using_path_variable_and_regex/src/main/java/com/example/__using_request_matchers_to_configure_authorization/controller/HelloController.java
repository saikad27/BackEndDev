package com.example.__using_request_matchers_to_configure_authorization.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code){
        return code;
    }

}
