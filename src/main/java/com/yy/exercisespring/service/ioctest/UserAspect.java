package com.yy.exercisespring.service.ioctest;

import org.aspectj.lang.ProceedingJoinPoint;

public class UserAspect {

    public void before1() {
        System.out.println("前置.............");
    }

    public void after1() {
        System.out.println("后置after1............");
    }
    public void afterReturning1() {
        System.out.println("最终afterReturning1............");
    }

    public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕后......");
    }

    public void ex() {
        System.out.println("出现异常............");
    }
}
