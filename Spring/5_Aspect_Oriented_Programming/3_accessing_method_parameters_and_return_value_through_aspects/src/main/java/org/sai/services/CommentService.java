package org.sai.services;

import org.sai.model.Comment;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService{
    private final Logger logger = Logger.getLogger(CommentService.class.getName());
    public String publishComment(Comment comment){
        logger.info("Publishing comment : "+comment.getText());
        return "Success";
    }
}