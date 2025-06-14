package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Player obj = context.getBean(Player.class);
        obj.setName("M Salah");
        System.out.println(obj.getClass());
        System.out.println(obj.getName());
    }
}
