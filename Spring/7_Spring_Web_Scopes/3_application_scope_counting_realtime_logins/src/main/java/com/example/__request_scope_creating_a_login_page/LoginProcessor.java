package com.example.__request_scope_creating_a_login_page;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

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

    public boolean login(){
        System.out.println("Session scoped bean : "+loggedUserManagementService);
        boolean loggedIn = false;

            if (username.equals("natalie") && password.equals("password")) {
                loggedIn = true;
                loggedUserManagementService.setUsername(username);
                loginCountService.incrementLoginCount();
            }

        return loggedIn;
    }
}
