package org.sai.service;

import java.util.logging.Logger;

import org.sai.model.Comment;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    Logger logger = Logger.getLogger(CommentService.class.getName());
    public String publishComment(Comment comment){
        logger.info("Publishing comment : "+comment);
        return "SUCCESS";
    }
}
