package com.yy.exercisespring.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类
 * HandlerExceptionResolver 该接口的每个实现类都是处理异常的一种实现方式
 */
@ControllerAdvice
public class ApiControllerAdvice {

    //@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "异常了!!!!!!")//页面异常
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)//页面正常
    @ExceptionHandler({Exception.class}) //如果此注解写在controller中,则只对当前controller生效
    public ModelAndView handleException(Exception e)
    {
        ModelAndView mv = new ModelAndView("success");
        System.out.println(e+ "111111"+"@ControllerAdvice");

        mv.addObject("er", e);
        return mv;
    }
}
