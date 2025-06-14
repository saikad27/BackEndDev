package org.sai.aspects;

import org.sai.model.Comment;

import java.util.logging.Logger;
import java.util.Arrays;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(String org.sai.services.CommentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] arguments = joinPoint.getArgs();


        Comment comment = new Comment();
        comment.setText("You have been hacked");
        comment.setAuthor("Hacker OP");
        Object[] newArguments = new Object[]{comment};
        Object returnValue = joinPoint.proceed(newArguments);

        logger.info("Method name : "+joinPoint.getSignature().getName()+",Method parameters"+Arrays.asList(arguments));
        logger.info("Method call returned : "+returnValue);
        return "Abrakadabra";
    }
}
