package com.example.rest_soap_graphql_api_tutorial.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfig {

    @Bean
    public List<User> userRepository(){
        return new ArrayList<>();
    }
}
