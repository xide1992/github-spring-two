package com.yy.exercisespring.controller;

import com.alibaba.fastjson.JSON;
import com.yy.exercisespring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "testParam", method = RequestMethod.GET)
    public String testParam(@RequestParam("uname") String uname,
                            @RequestParam(value = "uage", required = false,defaultValue = "23")Integer uage,
                            @RequestHeader(value = "sdf",required = false)String sdf,
                            @RequestHeader(value = "Accept-Language",required = false)String language,
                            @RequestHeader(value = "Cookie",required = false)String cookie,
                            @CookieValue(value = "JSESSIONID",required = false)String jsessionid) {
        //String name=request.getParameter("uname");
        System.out.println("name:" + uname+"age"+uage);
        System.out.println("sdf:" + sdf);
        System.out.println("language:" + language);
        System.out.println("cookie:" + cookie);
        System.out.println("jsessionid:" + jsessionid);
        return "success";  // 默认使用了请求转发的跳转方式
    }


    @RequestMapping(value = "testObjectProperties", method = RequestMethod.POST)
    public String testObjectProperties(Student student) {
        System.out.println("student:" + JSON.toJSONString(student));

        return "success";  // 默认使用了请求转发的跳转方式
    }

}
