package com.petroandrushchak.aop;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static io.qameta.allure.util.AspectUtils.getParametersMap;
import static io.qameta.allure.util.NamingUtils.processNameTemplate;

@Slf4j
@Aspect
public class AllureStepsConsoleLogger {

    @Before("@annotation(io.qameta.allure.Step) && execution(* *(..))")
    public void beforeStep(JoinPoint joinPoint) {
        String stepName = getStepName(joinPoint);
        log.info("BEGIN: " + stepName);
    }

    private String getStepName(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Map<String, Object> parametersMap = getParametersMap(joinPoint);
        Method method = methodSignature.getMethod();
        Step step = method.getAnnotation(Step.class);
        String stepName = step.value();

        return Optional.of(stepName)
                .filter(StringUtils::isNoneEmpty)
                .map(it -> processNameTemplate(it, parametersMap))
                .orElse(methodSignature.getName());
    }

}
