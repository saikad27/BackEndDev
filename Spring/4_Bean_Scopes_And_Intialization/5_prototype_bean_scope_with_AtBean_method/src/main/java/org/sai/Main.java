package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/*
* Prototype scope : If a bean scope is defined to be a prototype, you get a new instance every-time
* you reference it's bean-id.
*
*
* Note : Do not use a prototype scoped bean as an attribute of a singleton bean.
* As you will end up using the same instance of the prototype scoped bean every-time.
*
*/

public class Main {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommentService cs1 = context.getBean("commentService",CommentService.class);//new CommentService instance
        CommentService cs2 = context.getBean("commentService",CommentService.class);//new CommentService instance
        boolean b = cs1==cs2;
        System.out.println(b);
    }
}
