package com.example.__creating_an_oauth2_authorization_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/callback")
    public String callBackController(@RequestParam String code){
        return "Auth code : "+code;
    }

}
