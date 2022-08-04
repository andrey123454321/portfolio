package com.zaurtregulov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.deo.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        System.out.println("Begin of" + methodName);
        proceedingJoinPoint.proceed();//запускаем метод, к которому относится адвайс
        Object targetMethodResult = proceedingJoinPoint.proceed();//получаем результат метода
        System.out.println("Method end of" + methodName);
        return targetMethodResult;
    }
}
