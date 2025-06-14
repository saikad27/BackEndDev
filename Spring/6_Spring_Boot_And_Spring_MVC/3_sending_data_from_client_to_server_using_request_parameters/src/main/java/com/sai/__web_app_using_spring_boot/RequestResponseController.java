package com.sai.__web_app_using_spring_boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestResponseController{

    @RequestMapping("/home")
    public String home(@RequestParam(required=false) String color,@RequestParam(required=false) String name,Model model){
        model.addAttribute("name",name);
        model.addAttribute("color",color);
        return "home.html";
    }

}