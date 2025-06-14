package com.example.__request_scope_creating_a_login_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private LoginProcessor loginProcessor;
    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    @PostMapping("/")
    public String loginAction(@RequestParam String username,@RequestParam String password,Model model){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        if(loginProcessor.login()){
            return "redirect:/main";
        }

        model.addAttribute("message","Login Failed!");
        return "login.html";
    }
    @GetMapping("/")
    public String loginAction(){
        return "login.html";
    }
}
