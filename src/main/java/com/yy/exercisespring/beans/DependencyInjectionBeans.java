package com.yy.exercisespring.beans;
import java.util.Properties;
import javax.servlet.ServletContext;
import org.springframework.core.io.Resource;


import com.yy.exercisespring.common.MyConvert;
import com.yy.exercisespring.common.MyConvert2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

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

    /**
     * 文件上传      ,名称必须为 multipartResolver
     * @return
     */
    @Bean("multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setResolveLazily(false);
//        commonsMultipartResolver.setServletContext(new ServletContext());
        commonsMultipartResolver.setMaxUploadSize(1024 * 1024 * 1024);//上传文件大小,单位字节,-1表示无穷大
//        commonsMultipartResolver.setMaxUploadSizePerFile(0L);
        commonsMultipartResolver.setMaxInMemorySize(0);//内存开辟空间最大值
        commonsMultipartResolver.setDefaultEncoding("UTF-8");//文件编码
//        commonsMultipartResolver.setUploadTempDir(new Resource());
//        commonsMultipartResolver.setPreserveFilename(false);


        return commonsMultipartResolver;
    }


    /**
     * 以配置的方式处理异常
     *  @ExceptionHandler 优先级比此功能高, 需要先将 @ExceptionHandler  注释掉
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();

        Properties properties = new Properties();
        properties.put("java.lang.ArithmeticException", "error");
        properties.put("java.lang.NullPointerException", "error");

        simpleMappingExceptionResolver.setExceptionMappings(properties);
        simpleMappingExceptionResolver.setExceptionAttribute("ex");//把抛的异常ex放在requestScope  ,如果不写默认放在exception
        return simpleMappingExceptionResolver;


    }

}
