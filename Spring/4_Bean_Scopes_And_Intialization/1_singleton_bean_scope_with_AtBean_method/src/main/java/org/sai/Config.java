package org.sai;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class Config {

    @Bean
    public CommentService commentService(){
        CommentService cs = new CommentService();
        return cs;
    }
}
