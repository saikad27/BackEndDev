package org.sai.proxies;
import org.sai.model.Comment;
public interface CommentNotificationProxy {
    public abstract void sendComment(Comment comment);
}
