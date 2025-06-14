package com.example.__request_scope_creating_a_login_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    public MainController(LoggedUserManagementService loggedUserManagementService,LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }


    @GetMapping("/main")
    public String actionMethod(Model model){

        String username = loggedUserManagementService.getUsername();


        if(username == null){
            return "redirect:/";
        }else{
            model.addAttribute("username",username);
            model.addAttribute("loginCount",loginCountService.getLoginCount());
            return "home.html";
        }
    }
    @PostMapping("/main")
    public String actionMethod(@RequestParam String logout){
        if(logout.equals("Logout")) {
            loggedUserManagementService.setUsername(null);
            return "redirect:/logout";
        }
        return "redirect:/main";
    }

    @GetMapping("/logout")
    public String logoutAction(){
        return "logout.html";
    }

    @PostMapping("/logout")
    public String action4(@RequestParam String login){
        if(login.equals("Login"))
            return "redirect:/";
        return "redirect:/logout";
    }
}
