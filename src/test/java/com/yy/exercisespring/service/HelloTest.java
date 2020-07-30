package com.yy.exercisespring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xdz
 * @Descrption:
 * @Date: 2020/7/30 18:59
 */
public class HelloTest {

    @Test
    public void beanTest() {
        //加载spring配置文件,创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beanTest.xml");
        //得到配置创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);
        user.sayHello();
    }
}
