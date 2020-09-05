package com.yy.exercisespring.common;

import com.yy.exercisespring.model.Address;
import com.yy.exercisespring.model.Student;
import org.springframework.core.convert.converter.Converter;


public class MyConvert implements Converter<String, Student> {
    @Override
    public Student convert(String s) {//s:2-xdz-homeadd-schooladd

        Student student = new Student();

        String[] stuStrs = s.split("-");
        student.setAge(Integer.parseInt(stuStrs[0]));
        student.setName(stuStrs[1]);
        Address address = new Address();
        student.setAddress(address);
        address.setHomeAddress(stuStrs[2]);
        address.setSchoolAddress(stuStrs[3]);

        return student;
    }
}
