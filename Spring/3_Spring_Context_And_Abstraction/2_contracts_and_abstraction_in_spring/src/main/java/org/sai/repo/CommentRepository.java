package org.sai.repo;
import org.sai.model.Comment;
public interface CommentRepository {
    public abstract void saveComment(Comment comment);
}
