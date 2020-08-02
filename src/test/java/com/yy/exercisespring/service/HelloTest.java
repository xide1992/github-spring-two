package com.yy.exercisespring.service;

import com.yy.exercisespring.service.ioctest.AnnotationUser;
import com.yy.exercisespring.service.ioctest.User;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //得到配置创建的对象
        User user1 = (User) context.getBean("user");
        System.out.println(user1);
        user1.sayHello111();
        user1.output();

        User user2 = (User) context.getBean("staticFactoryUser");
        System.out.println(user2);
        user2.sayHello();

        User user3 = (User) context.getBean("userBean");
        System.out.println(user3);
        user3.sayHello();

        User userP = (User) context.getBean("userP");
        System.out.println(userP);
        userP.sayHello();


        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void annotationBeanTest() {
        //加载spring配置文件,创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationBean.xml");
        //得到配置创建的对象
        AnnotationUser user1 = (AnnotationUser) context.getBean("AnnotationUser");
        System.out.println(user1);
        user1.sayHello();
    }

    @Test
    public void aopBeanTest() {
        //加载spring配置文件,创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("aopBean.xml");
        //得到配置创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);
        user.sayHello();
    }
}
