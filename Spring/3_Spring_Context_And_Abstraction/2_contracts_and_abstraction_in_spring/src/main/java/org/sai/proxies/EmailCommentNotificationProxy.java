package org.sai.proxies;
import org.sai.model.Comment;
import org.springframework.stereotype.Component;
@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sendComment(Comment comment){
        System.out.println("Sending comment : "+comment.getText());
    }
}
