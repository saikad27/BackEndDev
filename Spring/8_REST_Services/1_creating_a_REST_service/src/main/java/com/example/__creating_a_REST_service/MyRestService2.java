package com.example.__creating_a_REST_service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyRestService2 {

    @GetMapping("/")
    public String getService(){
        return "This is a rest service";
    }

}
