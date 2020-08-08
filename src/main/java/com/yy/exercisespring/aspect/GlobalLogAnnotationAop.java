package com.yy.exercisespring.aspect;

import com.alibaba.fastjson.JSON;
import com.yy.exercisespring.annotation.GlobalLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class GlobalLogAnnotationAop {

    //环绕通知
    @Around("@annotation(com.yy.exercisespring.annotation.GlobalLog)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();

        GlobalLog globalLogAnnotation = method.getAnnotation(GlobalLog.class);

        boolean isThrown = false;
        Throwable throwable = null;
        Object value = null;
        try {
            //前置通知
            return value = proceedingJoinPoint.proceed();
            //后置通知
        } catch (Throwable t) {
            //异常通知
            throw t;
        } finally {
            //最终通知
            System.out.println(JSON.toJSON(globalLogAnnotation));
        }
    }

    /**
     * 前置通知
     *
     * @param jp
     */
    @Before("@annotation(com.yy.exercisespring.annotation.GlobalLog)")
    public void before(JoinPoint jp) {
        StringBuilder sbLog = new StringBuilder();
        sbLog.append("<注解形式实现aop.......前置通知>");
        sbLog.append("目标对象:").append(jp.getTarget());
        sbLog.append(",方法名").append(jp.getSignature().getName());
        sbLog.append(",参数列表:").append(JSON.toJSONString(jp.getArgs()));
        System.out.println(sbLog.toString());
    }

    /**
     * 后置通知
     *
     * @param jp
     * @param returningValue
     */
    @AfterReturning(pointcut = "@annotation(com.yy.exercisespring.annotation.GlobalLog)", returning = "returningValue")
    public void afterReturning(JoinPoint jp, Object returningValue) {
        StringBuilder sbLog = new StringBuilder();
        sbLog.append("<注解形式实现aop.......后置通知>");
        sbLog.append("目标对象:").append(jp.getTarget());
        sbLog.append(",方法名").append(jp.getSignature().getName());
        sbLog.append(",参数列表:").append(JSON.toJSONString(jp.getArgs()));
        sbLog.append(",返回参数:").append(returningValue);
        System.out.println(sbLog.toString());
    }

    /**
     * 最终通知
     *
     * @param jp
     */
    @After("@annotation(com.yy.exercisespring.annotation.GlobalLog)")
    public void after(JoinPoint jp) {
        StringBuilder sbLog = new StringBuilder();
        sbLog.append("<注解形式实现aop.......最终通知>");
        sbLog.append("目标对象:").append(jp.getTarget());
        sbLog.append(",方法名").append(jp.getSignature().getName());
        sbLog.append(",参数列表:").append(JSON.toJSONString(jp.getArgs()));
        System.out.println(sbLog.toString());
    }

    /**
     * 异常通知
     *
     * @param jp
     * @param e
     */
    @AfterThrowing(pointcut = "@annotation(com.yy.exercisespring.annotation.GlobalLog)", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        StringBuilder sbLog = new StringBuilder();
        sbLog.append("<注解形式实现aop.......异常通知>");
        sbLog.append("目标对象:").append(jp.getTarget());
        sbLog.append(",方法名").append(jp.getSignature().getName());
        sbLog.append(",异常:").append(e);
        System.out.println(sbLog.toString());
    }


}
