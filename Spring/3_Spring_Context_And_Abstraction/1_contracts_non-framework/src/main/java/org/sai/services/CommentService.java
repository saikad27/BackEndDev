package org.sai.services;
import org.sai.model.Comment;
import org.sai.proxies.CommentNotificationProxy;
import org.sai.repo.CommentRepository;
public class CommentService {
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
    public void publishComment(Comment comment){
        commentRepository.store(comment);
        commentNotificationProxy.send(comment);
    }
}
