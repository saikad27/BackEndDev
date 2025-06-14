package org.sai.repo;
import org.sai.model.Comment;
import org.springframework.stereotype.Repository;
@Repository
public class DBCommentRepository implements CommentRepository{
    public void saveComment(Comment comment) {
        System.out.println("Saving comment : "+comment.getText());
    }
}
