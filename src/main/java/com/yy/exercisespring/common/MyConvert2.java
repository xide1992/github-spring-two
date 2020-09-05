package com.yy.exercisespring.common;

import com.alibaba.fastjson.JSON;
import com.yy.exercisespring.model.Teacher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class MyConvert2 implements Converter<String, Teacher> {
    @Override
    public Teacher convert(String s) {
        return JSON.parseObject(s, Teacher.class);
    }
}
