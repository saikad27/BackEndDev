package com.example.__request_scope_creating_a_login_page;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private int loginCount;

    public int getLoginCount() {
        return loginCount;
    }

    public void incrementLoginCount() {
        loginCount++;
    }
}
