package com.yy.exercisespring.service.ioctest;

import com.yy.exercisespring.dao.ioctest.AnnotationUserBao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component(value = "AnnotationUser") //相当于 <bean id="AnnotationUser" class=
//@Controller("AnnotationUser")
//@Service("AnnotationUser")
//@Repository("AnnotationUser")
@Scope("singleton")
public class AnnotationUser {

    @Autowired  //找AnnotationUserBao方法名
    //@Resource
    //@Resource(name="AnnotationUserBao")// 如果带name，那么必须使用@Service(value="xxx") 中的value   或者不带name
    private AnnotationUserBao annotationUserBao;

    //    @Autowired
    //@Resource
    @Resource(name="userhhh")
    private User user;

    public void sayHello() {
        System.out.println("AnnotationUser.................");
        annotationUserBao.sayHello();
        user.sayHello();
    }
}
