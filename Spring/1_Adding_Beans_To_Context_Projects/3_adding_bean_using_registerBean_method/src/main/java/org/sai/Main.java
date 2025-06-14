package org.sai;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.function.Supplier;
public class Main {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        Person p = new Person("Hozier");
        Supplier<Person> supplier = () -> p;
        context.registerBean("person1",Person.class,supplier);
        context.refresh();
        Person beanPerson = context.getBean(Person.class);
        System.out.println(beanPerson.getName());
    }
}
