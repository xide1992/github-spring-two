package com.yy.exercisespring.service.ioctest;

import com.alibaba.fastjson.JSON;
import com.yy.exercisespring.dao.ioctest.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: xdz
 * @Descrption:
 * @Date: 2020/7/30 18:55
 */
public class User {

    private String userName;

    private UserDao userDao;

    private String [] arrs;
    private List<String> arrlist;
    private Map<String,String> map;
    private Properties properties;

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

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setArrlist(List<String> arrlist) {
        this.arrlist = arrlist;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void sayHello111() {
        System.out.println("hello111......" + this.userName);
        this.userDao.sayHello();
    }

    public void sayHello() {
        //throw new RuntimeException();
        System.out.println("hello22......" + this.userName);
    }

    public void output() {
        System.out.println(JSON.toJSONString(arrs));
        System.out.println(JSON.toJSONString(arrlist));
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(map));
    }


    public void init() {
        System.out.println("user---init");
    }

    public void destory() {
        System.out.println("user---destory");
    }


}
