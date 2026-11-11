package com.example.spring_websocket_tutorial.messagingstompwebsocket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homeController(){
        return "index.html";
    }
}
