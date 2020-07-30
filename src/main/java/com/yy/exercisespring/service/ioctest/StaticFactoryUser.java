package com.yy.exercisespring.service.ioctest;

public class StaticFactoryUser {

    public static User getUser() {
        return new User();
    }
}
