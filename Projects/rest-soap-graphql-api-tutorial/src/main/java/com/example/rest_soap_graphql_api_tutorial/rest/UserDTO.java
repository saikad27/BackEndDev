package com.example.rest_soap_graphql_api_tutorial.rest;


public class UserDTO {

    String name;
    String age;

    public UserDTO() {
    }

    public UserDTO(String name, String age) {
        this.name = name;
        this.age = age;
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
