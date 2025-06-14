package org.sai.aspects;

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
        logger.info("Method name : "+joinPoint.getSignature().getName());
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method parameters"+Arrays.asList(arguments));
        Object returnValue = joinPoint.proceed();
        logger.info("Method call returned : "+returnValue);
        return returnValue;
    }
}
