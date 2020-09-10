package com.yy.exercisespring.common;

import com.yy.exercisespring.common.exceptions.ValidationFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * 异常处理类
 * HandlerExceptionResolver 该接口的每个实现类都是处理异常的一种实现方式
 */
@ControllerAdvice
public class ApiControllerAdvice {

    private boolean isDebugMode = true;

    //@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED,reason = "异常了!!!!!!")//页面异常
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)//页面正常
    @ExceptionHandler({Exception.class}) //如果此注解写在controller中,则只对当前controller生效
    public ModelAndView handleException(Exception e) {
        ModelAndView mv = new ModelAndView("success");
        System.out.println(e + "111111" + "@Exception");

        mv.addObject("ex", e);
        return mv;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationFailureException.class})
    //@ResponseBody
    public ModelAndView validationFailureExceptionHandler(HttpServletResponse response, ValidationFailureException e) {
        if (isDebugMode) {
            e.printStackTrace();
        }
        System.out.println(e + "111111" + "@ValidationFailureException");
        return handleValidationFailure(response, e.getMessage());
    }

    @ExceptionHandler(value = {BindException.class})
    //@ResponseBody
    public ModelAndView BindExceptionHandler(HttpServletResponse response, BindException e) {
        FieldError error = e.getBindingResult().getFieldError();
        System.out.println("111111" + "@BindException"+e);
        return error != null ?
                handleValidationFailure(response, String.format("[%s] %s.", error.getField(), error.getDefaultMessage()))
                : handleValidationFailure(response, "Some field validate failure.");
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    //@ResponseBody
    public ModelAndView methodArgumentNotValidExceptionHandler(HttpServletResponse response, MethodArgumentNotValidException e) {
        FieldError error = e.getBindingResult().getFieldError();
        System.out.println( "111111" + "@methodArgumentNotValidExceptionHandler"+e);
        return error != null ?
                handleValidationFailure(response, String.format("[%s] %s.", error.getField(), error.getDefaultMessage()))
                : handleValidationFailure(response, "Some field validate failure.");
    }

    @NotNull
    private ModelAndView handleValidationFailure(HttpServletResponse response, String message) {
        response.setStatus(HttpServletResponse.SC_OK);

        ModelAndView mv = new ModelAndView("success");
        System.out.println(message + "111111" + "@handleValidationFailure");

        mv.addObject("ex", message);
        return mv;
    }


    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    //@ResponseBody
    public ModelAndView methodNowAllowHandler(HttpServletResponse response, HttpRequestMethodNotSupportedException e) {
        if (isDebugMode) {
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView("success");
        System.out.println(e + "111111" + "@HttpRequestMethodNotSupportedException");

        mv.addObject("ex", e);
        return mv;
    }
}
