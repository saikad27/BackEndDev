package org.sai;
import org.sai.services.CommentService;
import org.sai.repo.DBCommentRepository;
import org.sai.proxies.EmailCommentNotificationProxy;
import org.sai.model.*;
public class Main
{
    public static void main( String[] args )
    {
        CommentService service = new CommentService(new DBCommentRepository(),new EmailCommentNotificationProxy());
        Comment comment = new Comment();
        comment.setAuthor("Baba Yaga");
        comment.setCommentText("Demo Comment");
        service.publishComment(comment);
    }
}
