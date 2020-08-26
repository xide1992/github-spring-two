package com.yy.exercisespring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface GlobalLog {

    String category() default "";

    String module() default "";

    String subCategory() default "";

    boolean writeFailureLog() default true;

    boolean writeSuccessLog() default true;
}
