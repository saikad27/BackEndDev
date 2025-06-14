package com.sai.__web_app_using_spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestResponseController{

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name","Nelson");
        model.addAttribute("color","red");
        return "home.html";
    }

}