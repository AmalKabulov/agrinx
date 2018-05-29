package com.ititon.web.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Aspect
public class AspectBean {
    private static final String SPACE = " ";
    private static final String COMMA_AND_SPACE = ", ";
    private static final String SERVICE_LOGGER_NAME = "service_logger";
    private static final String ERROR_LOGGER_NAME = "error_logger";

    private static final Logger SERVICE_LOGGER = Logger.getLogger(SERVICE_LOGGER_NAME);
    private static final Logger ERROR_LOGGER = Logger.getLogger(ERROR_LOGGER_NAME);




    @Pointcut("@annotation(com.ititon.annotation.Loggable)")
    public void markedLoggable() {
    }


    @AfterThrowing("markedLoggable()")
    public void logException() {

    }


    @Around("markedLoggable()")
    public Object log(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        final String className = joinPoint.getTarget().getClass().getSimpleName();
        final String signature = joinPoint.getSignature().getName();
        final String methodArgs = methodArgsToString(Arrays.asList(joinPoint.getArgs()));

        try {

            final StopWatch stopWatch = new StopWatch();
            SERVICE_LOGGER.info(beforeMessage(className, signature, methodArgs));
            stopWatch.start();
            result = joinPoint.proceed();
            stopWatch.stop();
            SERVICE_LOGGER.info(afterMessage(className, signature, methodArgs, stopWatch.getTotalTimeMillis()));

        } catch (Throwable throwable) {
            ERROR_LOGGER.info(throwable.getMessage(), throwable);
            throw throwable;
        }
        return result;
    }


    private String beforeMessage(final String className, final String signature, final String methodArgs) {
        return new StringBuilder("\nEnter in class: ").append(className).append("\n")
                .append(" running method: ").append(signature).append("(").append(methodArgs).append(")").toString();
    }


    private String afterMessage(final String className, final String signature, final String methodArgs, final long executionTime) {
        return new StringBuilder("\nExit from class: ").append(className).append("\n")
                .append(" finished method: ").append(signature)
                .append("(").append(methodArgs).append(")")
                .append("\n")
                .append("EXECUTION TIME: ").append(executionTime).append(" ms.").toString();
    }

    private String methodArgsToString(final List<Object> args) {
        StringBuilder methodArgs = new StringBuilder();
        args.forEach(o -> methodArgs.append(o).append(SPACE));

        return methodArgs
                .toString()
                .trim()
                .replaceAll(SPACE, COMMA_AND_SPACE);
    }
}
