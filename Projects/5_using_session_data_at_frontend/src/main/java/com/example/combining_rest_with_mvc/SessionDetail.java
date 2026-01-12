package com.example.combining_rest_with_mvc;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionDetail {
    private String username;

    public SessionDetail() {
        System.out.println("Session created successfully");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SessionDetail{" +
                "username='" + username + '\'' +
                '}';
    }
}
