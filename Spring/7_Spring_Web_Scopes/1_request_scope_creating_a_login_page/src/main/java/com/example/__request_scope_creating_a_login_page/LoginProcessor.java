package com.example.__request_scope_creating_a_login_page;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class LoginProcessor {
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkCred(){
        System.out.println(username);
        if(username.equals("natalie") && password.equals("password")){
            return "You have successfully logged in";
        }else{
            return "Login Failed";
        }
    }
}
