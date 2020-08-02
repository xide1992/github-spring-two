package com.yy.exercisespring.service.ioctest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AopAnnotationAspectUser {

    @Before(value = "execution(* com.yy.exercisespring.service.ioctest.User.*(..))")
    public void before1() {
        System.out.println("前置通知.............");
    }

    @After(value = "execution(* com.yy.exercisespring.service.ioctest.User.*(..))")
    public void after1() {
        System.out.println("after:最终通知,在后置通知之前执行,如果抛出异常也会执行............");
    }
    @AfterReturning(value = "execution(* com.yy.exercisespring.service.ioctest.User.*(..))")
    public void afterReturning1() {
        System.out.println("afterReturning:后置通知............");
    }

    @Around(value = "execution(* com.yy.exercisespring.service.ioctest.User.*(..))")
    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前通知......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕后通知......");
    }

    @AfterThrowing(value = "execution(* com.yy.exercisespring.service.ioctest.User.*(..))")
    public void ex() {
        System.out.println("出现异常时执行............");
    }
}
