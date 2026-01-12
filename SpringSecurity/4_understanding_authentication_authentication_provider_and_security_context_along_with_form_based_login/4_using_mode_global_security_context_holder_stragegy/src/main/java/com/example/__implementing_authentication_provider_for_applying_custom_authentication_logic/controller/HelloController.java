package com.example.__implementing_authentication_provider_for_applying_custom_authentication_logic.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String helloController(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication= context.getAuthentication();
        return "Hello "+authentication.getName();
    }

    @ResponseBody
    @GetMapping("/hello_again")
    @Async
    public void helloAgainController(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication= context.getAuthentication();
        System.out.println("Hello "+authentication.getName());
    }

    @ResponseBody
    @GetMapping("/hello_new_thread")
    public void helloNewThread(Authentication authentication){
        Runnable task = () -> {System.out.println("New thread says Hello "+authentication.getName());};
        Thread thread = new Thread(task);
        thread.run();
    }
}
