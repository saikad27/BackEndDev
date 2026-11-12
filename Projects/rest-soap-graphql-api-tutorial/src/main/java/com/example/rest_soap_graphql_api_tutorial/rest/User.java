package com.example.rest_soap_graphql_api_tutorial.rest;

import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String age;

    public User(UserDTO userDTO){
        this();
    }

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
