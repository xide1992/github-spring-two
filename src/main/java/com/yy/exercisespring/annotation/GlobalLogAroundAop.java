package com.yy.exercisespring.annotation;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class GlobalLogAroundAop {

    @Around("@annotation(com.yy.exercisespring.annotation.GlobalLog)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

        GlobalLog globalLogAnnotation = method.getAnnotation(GlobalLog.class);

        boolean isThrown = false;
        Throwable throwable = null;
        Object value = null;
        try {
            return value = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
            System.out.println(JSON.toJSON(globalLogAnnotation));
        }
    }
}
