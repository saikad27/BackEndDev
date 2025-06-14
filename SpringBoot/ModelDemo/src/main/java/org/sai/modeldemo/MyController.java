package org.sai.modeldemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MyController {

    @GetMapping("/example")
    public String showExample(Model model){
        MyObject obj = new MyObject();
        obj.setName("Key");
        obj.setValue("Value");
        model.addAttribute("obj",obj);
        return "example";
    }
}

