package com.yy.exercisespring.service.ioctest;

import com.yy.exercisespring.annotation.GlobalLog;
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

    @GlobalLog(module = "xdz",category = "xdzCategory",subCategory = "hhh",writeFailureLog = false,writeSuccessLog = false)
    public void sayHello() {
        System.out.println("AnnotationUser.................");
        annotationUserBao.sayHello();
        user.sayHello();
    }

    @GlobalLog(module = "xdz",category = "xdzCategory",subCategory = "hhh",writeFailureLog = false,writeSuccessLog = false)
    public int sayAop(int ii,int jj) {
//        int  hhh[]=new int[2];
//        hhh[3]=1231;
        System.out.println("Annotation....AOP............."+ii+jj);
        return ii+jj;
    }
}
