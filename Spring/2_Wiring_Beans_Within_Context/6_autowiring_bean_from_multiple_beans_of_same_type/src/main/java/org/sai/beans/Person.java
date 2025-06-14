package org.sai.beans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class Person {
    private String name;
    private Dog pet;


    @Autowired
    public Person(@Qualifier("dog1") Dog pet){
        this.name = "John Wick";
        this.pet = pet;
    }

    public Person(){

    }
    /*
    @Autowired
    public Person(Dog pet){
        this.pet = pet;
        name = "Pratik";
    }
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getPet() {
        return pet;
    }

    public void setPet(Dog pet){
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
