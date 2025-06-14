package org.sai;
import org.sai.model.Comment;
import org.sai.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sai.services.CommentService;

public class Main
{
    public static void main( String[] args )
    {
        Comment comment = new Comment();
        comment.setText("It's time for my little research!");
        comment.setAuthor("Pervy Sage");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFile1.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publish(comment);
    }
}
