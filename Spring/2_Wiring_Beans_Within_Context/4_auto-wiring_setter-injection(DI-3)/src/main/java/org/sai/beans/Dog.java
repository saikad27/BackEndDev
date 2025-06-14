package org.sai.beans;
import org.springframework.stereotype.Component;
@Component
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public Dog() {
        this.name = "Tuffy";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
