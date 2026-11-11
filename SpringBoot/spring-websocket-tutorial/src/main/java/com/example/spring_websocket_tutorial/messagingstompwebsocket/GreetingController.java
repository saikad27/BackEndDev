package com.example.spring_websocket_tutorial.messagingstompwebsocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @MessageMapping("/send")
    @SendTo("/topic/greetings") //Those clients who subscribed to this topic will receive the greeting message whenever /hello endpoint is called
    public Greeting greeting(HelloMessage message) throws Exception{
        System.out.println(message);
        Thread.sleep(1000);
        return new Greeting("Hello "+message.getName());
    }

    @GetMapping("/get")
    public String getPage(){
        return "index.html";
    }

}
