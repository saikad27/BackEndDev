package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Eager Initialization : A bean is instantiated when the context is initialized.Spring uses this
 * initialization by default, a bean is initialized even if the bean isn't referenced or used.
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        
    }
}
