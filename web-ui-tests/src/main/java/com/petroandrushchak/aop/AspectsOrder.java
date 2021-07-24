package com.petroandrushchak.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclarePrecedence;

@Aspect
@DeclarePrecedence(
        "com.petroandrushchak.aop.AllureStepsConsoleLogger, " +
                "com.petroandrushchak.aop.AllureStepRetry, ")
public class AspectsOrder {
}