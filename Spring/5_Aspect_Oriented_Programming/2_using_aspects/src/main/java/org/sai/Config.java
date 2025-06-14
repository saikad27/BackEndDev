package org.sai;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages="org.sai")
public class Config {

    /*@Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }*/
}
