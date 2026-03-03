package com.example.__configuring_preauthorization_for_a_method_call.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.__configuring_preauthorization_for_a_method_call.service.NameService;

@RestController
public class HelloController {

    private final NameService nameService;

    public HelloController(NameService nameService){
        this.nameService = nameService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello "+nameService.getName();
    }
}
