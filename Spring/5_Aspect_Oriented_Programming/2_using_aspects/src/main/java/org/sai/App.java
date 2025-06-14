package org.sai;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Comment comment = new Comment();
        comment.setText("With great power comes great responsibility");
        comment.setAuthor("Uncle Ben");
        CommentService cs = context.getBean(CommentService.class);  //Proxy object
        cs.publish(comment);
    }
}
