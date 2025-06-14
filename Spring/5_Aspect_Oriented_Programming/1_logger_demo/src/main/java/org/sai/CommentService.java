package org.sai;
import java.util.logging.Logger;

public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    public void publish(Comment comment){
        logger.info("Publishing comment : "+comment.getText());
    }
}
