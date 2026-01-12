package com.example.combining_rest_with_mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @GetMapping("/get")
    public String getView(){
        return "home";
    }

    @ResponseBody
    @GetMapping("/data")
    public Object getData(){
        return new UserDetail(101,"Saket");
    }
}
