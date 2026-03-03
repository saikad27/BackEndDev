package com.example.__making_a_cross_origin_call.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MyWebController {

    Logger logger = Logger.getLogger(MyWebController.class.getName());
//    @GetMapping("/")
//    public String main(){
//        return "main.html";
//    }

    @CrossOrigin("http://localhost:8000")
    @ResponseBody
    @PostMapping("/test")
    public String test(){
        //System.out.println("/test controller called");

        logger.info("/test controller called");
        return "Hello";
    }
}
