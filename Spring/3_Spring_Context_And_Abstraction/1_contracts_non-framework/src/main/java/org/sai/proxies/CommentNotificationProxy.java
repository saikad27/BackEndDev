package org.sai.proxies;
import org.sai.model.Comment;
public interface CommentNotificationProxy {
    public void send(Comment comment);
}
