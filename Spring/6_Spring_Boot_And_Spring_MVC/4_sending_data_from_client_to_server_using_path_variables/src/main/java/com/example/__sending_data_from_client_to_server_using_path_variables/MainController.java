package com.example.__sending_data_from_client_to_server_using_path_variables;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/home/{color}")
    public String home(@PathVariable String color, Model model){
        model.addAttribute("name","John");
        model.addAttribute("color",color);
        return "home";
    }
}
