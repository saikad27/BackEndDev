package org.sai.services;
import org.sai.model.Comment;
import org.sai.proxies.CommentNotificationProxy;
import org.sai.repo.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    CommentRepository commentRepository;
    CommentNotificationProxy commentNotificationProxy;

   public CommentService(CommentRepository commentRepository,CommentNotificationProxy commentNotificationProxy){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publish(Comment comment){
        commentRepository.saveComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
