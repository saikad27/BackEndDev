package org.sai.aspects;

import org.sai.model.Comment;
import org.sai.annotation.ToLog;

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


    @Around("@annotation(org.sai.annotation.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method name : "+joinPoint.getSignature().getName()+",Method parameters"+Arrays.asList(arguments));

        return joinPoint.proceed();
    }
}
