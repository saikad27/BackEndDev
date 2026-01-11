package com.example.combining_rest_with_mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    private final SessionDetail sessionDetail;
    public WebController(SessionDetail sessionDetail){
        this.sessionDetail = sessionDetail;
    }
    @GetMapping("/home")
    public String getView(@RequestParam String username, Model model){
        sessionDetail.setUsername(username);
        model.addAttribute("sessionDetail",sessionDetail.getUsername());
        return "home";
    }

    @ResponseBody
    @PostMapping("/getSession")
    public String getSessionDetails(){
        System.out.println(sessionDetail);
        return sessionDetail.toString();
    }

    @GetMapping("/login")
    public Object login(){
        return "login";
    }
}
