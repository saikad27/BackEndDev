package com.example.__implementing_authentication_provider_for_applying_custom_authentication_logic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String helloController(){
        return "Hello world";
    }
}
