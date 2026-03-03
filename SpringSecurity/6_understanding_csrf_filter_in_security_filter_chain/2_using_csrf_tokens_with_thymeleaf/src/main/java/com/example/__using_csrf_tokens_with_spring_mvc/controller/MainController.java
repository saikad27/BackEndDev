package com.example.__using_csrf_tokens_with_spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/main")
    public String getMain(){
        
        return "main.html";
    }
}
