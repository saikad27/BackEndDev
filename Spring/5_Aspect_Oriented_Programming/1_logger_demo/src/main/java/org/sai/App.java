package org.sai;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Logger : It's similar to the System.out.println(), just the fact that it provides more flexibility.
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommentService cs = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("Welcome to AOP");
        comment.setAuthor("Mr. Nobody");
        cs.publish(comment);
    }
}
