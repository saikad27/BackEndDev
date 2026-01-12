package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan("org.example")
public class ProjectConfig {

    @Bean
    public MyClass mybean1(NewComponent myComponent){
        MyClass myclass = new MyClass(myComponent);
        myclass.setName("mybean");
        return myclass;
    }

}
