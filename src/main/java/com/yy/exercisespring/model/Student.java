package com.yy.exercisespring.model;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import java.util.Date;

public class Student {

    private String name;
    @NumberFormat(pattern = "###,#")
    private int age;
    private Address address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Email
    private String email;

    public String getName() {
        return name;
    }

    public  Student(){}

    public Student(String name,int age,String email){
        this.name=name;
        this.age=age;
        this.email=email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
