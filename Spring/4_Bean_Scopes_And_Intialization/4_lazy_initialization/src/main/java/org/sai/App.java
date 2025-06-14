package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Lazy Initialization : A bean is instantiated only when it's referenced for the first time.
 * This way a bean only gets instantiated when it's needed.
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Context is initialized, but the lazy bean isn't instantiated yet.");
        System.out.println("Before referencing the bean.");
        context.getBean(SampleBean.class);  //Lazy bean is referenced here
        System.out.println("After referencing the bean.");
    }
}
