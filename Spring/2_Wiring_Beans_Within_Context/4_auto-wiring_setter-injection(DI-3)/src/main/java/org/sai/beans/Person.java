package org.sai.beans;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Person {
    private String name;

    private Dog pet;

    public Person() {
        this.name = "Billy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getPet() {
        return pet;
    }

    @Autowired
    //Wiring through Dependency Injection (setter-injection)
    public void setPet(Dog pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pet='" + pet + '\'' +
                '}';
    }
}
