package com.yy.exercisespring.dao.ioctest;

        import org.springframework.stereotype.Service;

@Service("xdzAnnotationUserBao")
public class AnnotationUserBao {
    public void sayHello() {
        System.out.println("AnnotationUserBao......");
    }
}
