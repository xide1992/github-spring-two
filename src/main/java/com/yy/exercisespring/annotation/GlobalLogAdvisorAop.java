package com.yy.exercisespring.annotation;

import com.alibaba.fastjson.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class GlobalLogAdvisorAop implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Method method = methodInvocation.getMethod();

        GlobalLog globalLogAnnotation = method.getAnnotation(GlobalLog.class);

        boolean isThrown = false;
        Throwable throwable = null;
        Object value = null;
        try {
            return value = methodInvocation.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
            System.out.println(JSON.toJSON(globalLogAnnotation));
        }
    }
}
