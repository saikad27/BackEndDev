package org.sai;

import org.sai.beans.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person p = context.getBean(Person.class);
        Dog d = context.getBean(Dog.class);
        System.out.println(p);
        System.out.println(d);
    }
}
