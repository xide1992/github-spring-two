package com.yy.exercisespring.service.ioctest;

import com.yy.exercisespring.dao.ioctest.UserDao;

/**
 * @Author: xdz
 * @Descrption:
 * @Date: 2020/7/30 18:55
 */
public class User {

    private String userName;

    private UserDao userDao;

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

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void sayHello111() {
        System.out.println("hello111......" + this.userName);
        this.userDao.sayHello();
    }

    public void sayHello() {
        System.out.println("hello22......" + this.userName);
    }

    public void init() {
        System.out.println("user---init");
    }

    public void destory() {
        System.out.println("user---destory");
    }


}
