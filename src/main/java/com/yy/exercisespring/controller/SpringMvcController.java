package com.yy.exercisespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("spring/mvc")//映射
public class SpringMvcController {

    @RequestMapping("welcome")
    public String welcome() {
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "welcome1", method = RequestMethod.POST, params = {"name=xdz", "age!=23", "!height"})
    public String welcome1() {
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "welcome2", method = RequestMethod.POST, headers = {"Accept-Encoding=gzip, deflate", ""})
    public String welcome2() {
        return "success";  // 默认使用了请求转发的跳转方式
    }


    /*
    ant风格的请求路径
    ?单字符
    *任意个字符(0个或多个)
    **任意目录
     */

    @RequestMapping(value = "welcome3/**/test")
    public String welcome3() {
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "welcome4/a?c/test")
    public String welcome4() {
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "welcome5/{name}")
    public String welcome5(@PathVariable("name") String name) {
        System.out.println(name);
        return "success";  // 默认使用了请求转发的跳转方式
    }


    @RequestMapping(value = "testRestful/{id}",method = RequestMethod.POST)
    public String testAdd(@PathVariable("id") Long id) {
        System.out.println("增"+id);
        return "success";  // 默认使用了请求转发的跳转方式
    }
    @RequestMapping(value = "testRestful/{id},",method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Long id) {
        System.out.println("删"+id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testRestful/{id}",method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") Long id) {
        System.out.println("改"+id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testRestful/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Long id) {
        System.out.println("查"+id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

}
