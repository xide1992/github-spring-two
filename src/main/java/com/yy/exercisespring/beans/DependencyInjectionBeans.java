package com.yy.exercisespring.beans;


import com.yy.exercisespring.common.MyConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DependencyInjectionBeans {


    @Autowired
    private MyConvert myConvert;

    @Bean("conversionService")
    public ConversionServiceFactoryBean getConversionServiceFactoryBean() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<MyConvert> converters = new HashSet<>();
        converters.add(myConvert);
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }
}
