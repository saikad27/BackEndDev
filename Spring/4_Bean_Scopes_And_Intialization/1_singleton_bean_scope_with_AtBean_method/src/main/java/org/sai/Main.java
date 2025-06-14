package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommentService cs1 = context.getBean("commentService",CommentService.class);
        CommentService cs2 = context.getBean("commentService",CommentService.class);
        boolean b = cs1==cs2;
        System.out.println(b);
    }
}
