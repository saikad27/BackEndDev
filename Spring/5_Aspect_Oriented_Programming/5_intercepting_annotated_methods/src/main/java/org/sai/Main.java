package org.sai;

import org.sai.model.Comment;
import org.sai.config.Config;
import org.sai.services.CommentService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.logging.Logger;

public class Main {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CommentService cs = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("Just a random comment");
        comment.setAuthor("Random Guy");
        String str = cs.publishComment(comment);
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("publishComment() returned : "+str);
    }
}
