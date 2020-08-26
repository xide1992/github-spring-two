package com.yy.exercisespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMvcController {

    @RequestMapping("welcome")
    public String welcome()
    {
        return "success";
    }
}
