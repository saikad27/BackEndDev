package com.example.__using_request_matchers_to_configure_authorization.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/a")
    public String getEndpointA(){
        return "Works!";
    }
    @PostMapping("/a")
    public String postEndpointA(){
        return "Works!";
    }
    @GetMapping("/a/b")
    public String getEndpointAb(){
        return "Works!";
    }
    @GetMapping("/a/b/c")
    public String getEndpointAbc(){
        return "Works!";
    }
    @PostMapping("/a/b/c/d")
    public String getEndPointAbcd(){ return "Works!"; }

}
