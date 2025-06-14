package org.sai;

import org.sai.beans.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
//@ComponentScan(basePackages="org.sai.beans")
public class Config {

    @Bean()
    public Dog dog1(){
        Dog d = new Dog();
        d.setName("Daisy");
        return d;
    }

    @Bean()
   //@Primary
    public Dog dog2(){
        Dog d = new Dog();
        d.setName("Jimmy");
        return d;
    }

    @Bean
    public Person person(@Qualifier("dog1") Dog dog1){
        Person p = new Person();
        p.setName("Billy");
        p.setPet(dog1);
        return p;
    }

}
