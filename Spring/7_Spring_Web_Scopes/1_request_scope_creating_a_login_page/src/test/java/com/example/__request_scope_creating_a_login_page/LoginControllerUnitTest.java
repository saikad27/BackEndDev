package com.example.__request_scope_creating_a_login_page;

import com.example.__request_scope_creating_a_login_page.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTest {

    @Mock
    LoginProcessor loginProcessor;

    @Mock
    Model model;

    @InjectMocks
    LoginController loginController;

    @Test
    public void loginSuccessTest(){
        given(loginProcessor.checkCred()).willReturn("You have successfully logged in");
        String result = loginController.getLoginStatus("username","password",model);
        assertEquals("home.html",result);
        verify(model).addAttribute("message","You have successfully logged in");
    }

    @Test
    public void loginFailedTest(){
        given(loginProcessor.checkCred()).willReturn("Login Failed");
        String result = loginController.getLoginStatus("username","password",model);
        assertEquals("home.html",result);
        verify(model).addAttribute("message","Login Failed");
    }
}
