package com.yy.exercisespring.service.ioctest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class UserAspect {

    public void before1() {
        System.out.println("前置通知.............");
    }

    /**
     * 在后置通知之前执行,如果抛出异常也会执行
     */
    public void after1() {
        System.out.println("最终通知,在后置通知之前执行,如果抛出异常也会执行............");
    }
    public void afterReturning1() {
        System.out.println("后置通知............");
    }

    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前通知......");
        MethodSignature methodSignature=(MethodSignature) proceedingJoinPoint.getSignature();
        Method method=methodSignature.getMethod();
        proceedingJoinPoint.proceed();
        System.out.println("环绕后通知......"+method.getName());
    }

    public void ex() {
        System.out.println("出现异常............");
    }
}
