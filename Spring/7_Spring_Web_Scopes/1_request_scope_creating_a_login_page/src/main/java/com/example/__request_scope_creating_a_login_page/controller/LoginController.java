package com.example.__request_scope_creating_a_login_page.controller;

import com.example.__request_scope_creating_a_login_page.LoginProcessor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


@Controller
public class LoginController {

    @Autowired
    private LoginProcessor loginCred;

    @GetMapping("/")
    public String getView(){
        return "home.html";
    }

    @PostMapping("/")
    public String getLoginStatus(@RequestParam String username,@RequestParam String password,Model model){
        loginCred.setUsername(username);
        loginCred.setPassword(password);
        System.out.println(loginCred);
        model.addAttribute("message",loginCred.checkCred());
        return "home.html";
    }
}
