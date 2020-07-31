package com.yy.exercisespring.service.ioctest;

/**
 * @Author: xdz
 * @Descrption:
 * @Date: 2020/7/30 18:55
 */
public class User {

    private String userName;

    public User() {
        System.out.println("User无产构造方法");
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void sayHello() {
        System.out.println("hello......" + this.userName);
    }

    public void init() {
        System.out.println("user---init");
    }

    public void destory() {
        System.out.println("user---destory");
    }


}
