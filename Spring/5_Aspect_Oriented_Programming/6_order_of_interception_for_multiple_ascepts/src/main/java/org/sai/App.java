package org.sai;

import java.util.logging.Logger;

import org.sai.config.Config;
import org.sai.service.CommentService;
import org.sai.model.Comment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Comment comment = new Comment();
        comment.setText("Chin Tapak Dumdum");
        comment.setAuthor("Unknown");
        CommentService commentService = context.getBean(CommentService.class);
        String returnVal = commentService.publishComment(comment);
        Logger logger = Logger.getLogger(App.class.getName());
        logger.info("Method returned : "+returnVal);
    }
}
