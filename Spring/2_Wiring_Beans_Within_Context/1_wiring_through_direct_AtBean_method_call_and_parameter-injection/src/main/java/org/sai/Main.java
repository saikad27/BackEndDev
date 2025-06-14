package org.sai;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person p1 = context.getBean("person1",Person.class);
        Person p2 = context.getBean("person2",Person.class);
        Dog d1 = context.getBean("dog1",Dog.class);
        Dog d2 = context.getBean("dog2",Dog.class);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(d1);
        System.out.println(d2);
    }
}
