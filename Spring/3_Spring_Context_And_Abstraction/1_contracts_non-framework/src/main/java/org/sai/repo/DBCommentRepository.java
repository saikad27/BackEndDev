package org.sai.repo;
import org.sai.model.Comment;
public class DBCommentRepository implements CommentRepository{
    public void store(Comment comment){
        System.out.println("Storing : "+comment.getCommentText());
    }
}
