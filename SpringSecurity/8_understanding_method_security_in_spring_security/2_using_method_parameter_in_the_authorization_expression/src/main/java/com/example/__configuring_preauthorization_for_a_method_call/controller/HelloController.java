package com.example.__configuring_preauthorization_for_a_method_call.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.__configuring_preauthorization_for_a_method_call.service.NameService;

@RestController
public class HelloController {

    private final NameService nameService;

    public HelloController(NameService nameService){
        this.nameService = nameService;
    }

    @GetMapping("/secret/name/{name}")
    public String hello(@PathVariable String name){
        return "Hello "+nameService.getSecretNames(name);
    }
}
