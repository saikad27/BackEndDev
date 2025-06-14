package org.sai;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        CommentService s1 = context.getBean(CommentService.class);
        UserService s2 = context.getBean(UserService.class);

        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
    }
}
