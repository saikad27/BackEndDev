package org.sai.services;

import org.sai.model.Comment;
import org.sai.annotation.ToLog;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService{
    private final Logger logger = Logger.getLogger(CommentService.class.getName());
    public void publishComment(Comment comment){
        logger.info("Publishing comment : "+comment);
    }
    @ToLog
    public void deleteComment(Comment comment){
        logger.info("Deleting comment : "+comment);
    }
    public void editComment(Comment comment){
        logger.info("Editing comment : "+comment);
    }
}