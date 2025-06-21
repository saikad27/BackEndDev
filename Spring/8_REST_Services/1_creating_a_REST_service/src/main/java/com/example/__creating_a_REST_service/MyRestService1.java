package com.example.__creating_a_REST_service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyRestService1 {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello, there!";
    }

}
