package org.example;

public class MyClass {
    private final NewComponent myComponent;

    MyClass(NewComponent myComponent){
        System.out.println("Creating MyClass bean");
        this.myComponent = myComponent;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
