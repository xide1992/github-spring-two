package com.yy.exercisespring.beans;


import com.yy.exercisespring.common.MyConvert;
import com.yy.exercisespring.common.MyConvert2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DependencyInjectionBeans {


    @Autowired
    private MyConvert myConvert;

    @Autowired
    private MyConvert2 myConvert2;


//    /**
//     * 入参类型转换
//     * @return
//     */
//    @Bean("conversionService")
//    public ConversionServiceFactoryBean getConversionServiceFactoryBean() {
//        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
//        Set<Converter> converters = new HashSet<>();
//        converters.add(myConvert);
//        converters.add(myConvert2);
//        conversionServiceFactoryBean.setConverters(converters);
//        return conversionServiceFactoryBean;
//    }

    /**
     * 配置格式化所依赖的bean
     * FormattingConversionServiceFactoryBean 包含了ConversionServiceFactoryBean的功能
     *
     * @return
     */
    @Bean("conversionService")
    public FormattingConversionServiceFactoryBean getFormattingConversionServiceFactoryBean() {
        FormattingConversionServiceFactoryBean conversionServiceFactoryBean = new FormattingConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(myConvert);
        converters.add(myConvert2);
        conversionServiceFactoryBean.setConverters(converters);
        return conversionServiceFactoryBean;
    }
}
