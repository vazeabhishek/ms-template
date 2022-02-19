package com.invicto.ms.template.restms.aspects.impl;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class LogExecutionTimeImpl{

    @Around("@annotation(com.invicto.ms.template.restms.aspect.LogExecutionTime)")
    public Object logExecutionTimeToConsole(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        var stop = System.currentTimeMillis();
        log.info("{} -> Time taken to execute {} : {}ms", joinPoint.getSignature(), (stop - start));
        return proceed;
    }
}