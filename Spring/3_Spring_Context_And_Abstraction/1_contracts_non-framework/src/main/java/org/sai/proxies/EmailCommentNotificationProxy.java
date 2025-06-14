package org.sai.proxies;
import org.sai.model.Comment;
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    public void send(Comment comment){
        System.out.println("Sending comment : "+comment.getCommentText());
    }
}
