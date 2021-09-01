package com.petroandrushchak.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Slf4j
@Aspect
public class AllureStepRetry {

    private static final ThreadLocal<Boolean> processingWrapper = ThreadLocal.withInitial(() -> false);

    public static Boolean isProcessing() {
        return processingWrapper.get();
    }

    @Around("@annotation(com.petroandrushchak.aop.RetryStep) && execution(* *(..))")
    public Object handleRetries(final ProceedingJoinPoint joinPoint) throws Throwable {
        processingWrapper.set(true);
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        RetryStep annotation = method.getAnnotation(RetryStep.class);
        int retryCount = annotation.value();
        Throwable storedException = null;
        Object result = null;
        boolean processed = false;
        int i = 0;
        while (!processed && i < retryCount) {
            try {
                result = joinPoint.proceed();
                processed = true;
            } catch (Throwable throwable) {
                log.warn("Retry # " + i + ":\r\n" + throwable);
                storedException = throwable;
            }
            i++;
        }

        processingWrapper.set(false);

        if (!processed) {
            assert storedException != null;
            throw storedException;
        }

        return result;
    }


}
