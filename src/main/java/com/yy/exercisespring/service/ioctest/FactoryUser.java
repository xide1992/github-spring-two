package com.yy.exercisespring.service.ioctest;

public class FactoryUser {

    public User getUser() {
        return new User();
    }
}
