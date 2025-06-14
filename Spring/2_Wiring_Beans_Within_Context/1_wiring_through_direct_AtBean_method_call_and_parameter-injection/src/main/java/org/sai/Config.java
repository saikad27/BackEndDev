package org.sai;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
public class Config {
    @Bean()
    public Person person1() {

        Person p = new Person("Jim");
        p.setPet(dog1());    //wiring directly through method call
        return p;
    }
    @Bean()
    //spring-context passes the bean named dog2 while calling this method (IOC principle)
    public Person person2(@Qualifier("dog2") Dog d){
        Person p = new Person("Jake");
        p.setPet(d);    //wiring through received parameter from the spring-context
        return p;
    }
    @Bean Dog dog1(){
        Dog d = new Dog("Tuffy");
        return d;
    }
    @Bean Dog dog2(){
        Dog d = new Dog("Daisy");
        return d;
    }
}
