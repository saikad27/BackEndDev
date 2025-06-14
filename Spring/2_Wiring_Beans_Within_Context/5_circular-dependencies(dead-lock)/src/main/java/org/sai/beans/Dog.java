package org.sai.beans;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class Dog {
    private String name;
    private final Person owner;

    public String getName() {
        return name;
    }

    @Autowired
    public Dog(Person owner) {
        this.name = "Tuffy";
        this.owner = owner;
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
