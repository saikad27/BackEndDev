package org.sai.beans;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Person {
    private String name;

    private final Dog pet;

    @Autowired
    //Auto-wiring using constructor injection
    public Person(Dog pet) {
        this.name = "Billy";
        this.pet = pet;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pet='" + pet + '\'' +
                '}';
    }
}
