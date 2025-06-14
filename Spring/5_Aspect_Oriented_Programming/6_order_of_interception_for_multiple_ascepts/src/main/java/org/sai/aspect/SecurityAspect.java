package org.sai.aspect;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class SecurityAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(String org.sai.service.CommentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Calling intercepted method.");
        Object result = joinPoint.proceed();
        logger.info("Intercepted method call returned");
        return result;
    }
}
