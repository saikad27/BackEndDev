package org.sai.repo;
import org.sai.model.Comment;

public interface CommentRepository {
    public void store(Comment comment);
}
