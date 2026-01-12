package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class App {

    public static void main( String[] args )
    {
        //BeanFactory beanFactory = new ClassPathXmlApplicationContext("/beans.xml");
        ApplicationContext beanFactory = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println(beanFactory.getBean("mybean1",MyClass.class).getName());
        System.out.println(beanFactory.getBean(NewComponent.class).hashCode());
    }
}
