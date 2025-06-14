package org.sai.config;

import org.sai.proxies.*;
import org.sai.repo.*;
import org.sai.services.CommentService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.sai.proxies.CommentNotificationProxy;
import org.springframework.context.annotation.Bean;
import org.sai.repo.CommentRepository;

//@Configuration
@ComponentScan(basePackages={"org.sai"})
public class ConfigFile2 {

    @Bean
    public CommentRepository repository(){
        return new DBCommentRepository();
    }
    @Bean
    public CommentNotificationProxy proxy(){
        return new EmailCommentNotificationProxy();
    }
    @Bean
    public CommentService comment_service(){
        return new CommentService(repository(),proxy());
    }
}
