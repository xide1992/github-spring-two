package com.yy.exercisespring.controller;

import com.alibaba.fastjson.JSON;
import com.yy.exercisespring.model.Address;
import com.yy.exercisespring.model.Student;
import com.yy.exercisespring.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("spring/mvc")//映射
//@SessionAttributes(value = "student")
//@SessionAttributes(types = Student.class)
public class SpringMvcController {

    @RequestMapping("welcome")
    public String welcome() {
        return "success";  // 默认使用了请求转发的跳转方式 //除了String 还可以使用VieW  ,ModelAndView
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


    @RequestMapping(value = "testRestful/{id}", method = RequestMethod.POST)
    public String testAdd(@PathVariable("id") Long id) {
        System.out.println("增" + id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testRestful/{id},", method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Long id) {
        System.out.println("删" + id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testRestful/{id}", method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") Long id) {
        System.out.println("改" + id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testRestful/{id}", method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Long id) {
        System.out.println("查" + id);
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testParam", method = RequestMethod.GET)
    public String testParam(@RequestParam("uname") String uname,
                            @RequestParam(value = "uage", required = false, defaultValue = "23") Integer uage,
                            @RequestHeader(value = "sdf", required = false) String sdf,
                            @RequestHeader(value = "Accept-Language", required = false) String language,
                            @RequestHeader(value = "Cookie", required = false) String cookie,
                            @CookieValue(value = "JSESSIONID", required = false) String jsessionid) {
        //String name=request.getParameter("uname");
        System.out.println("name:" + uname + "age" + uage);
        System.out.println("sdf:" + sdf);
        System.out.println("language:" + language);
        System.out.println("cookie:" + cookie);
        System.out.println("jsessionid:" + jsessionid);
        return "success";  // 默认使用了请求转发的跳转方式
    }


    /**
     * 参数位置不要调整 因为BindingResult result报错前一个参数的错误消息
     * @param student
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "testObjectProperties", method = RequestMethod.POST)
    public String testObjectProperties(Student student, BindingResult result,Map map) {
        System.out.println("student:" + JSON.toJSONString(student));
        //BindingResult result 相当于tryCatch  ,页面上就不会报错
        if(result.getErrorCount()>0) {
            map.put("errors",result.getFieldErrors());
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println("Error11:"+fieldError.getDefaultMessage());
            }
        }
        return "success";  // 默认使用了请求转发的跳转方式
    }

    /**
     * 参数位置不要调整 因为BindingResult result报错前一个参数的错误消息
     * @param student
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "testHibernateValidator", method = RequestMethod.POST)
    public String testHibernateValidator(@Valid  Student student, BindingResult result, Map map) {
        System.out.println("student:" + JSON.toJSONString(student));
        //BindingResult result 相当于tryCatch  ,页面上就不会报错
        if(result.getErrorCount()>0) {
            map.put("errors",result.getFieldErrors());
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println("Error11:"+fieldError.getDefaultMessage());
            }
        }
        return "success";  // 默认使用了请求转发的跳转方式
    }


    @RequestMapping(value = "testHttpServlet")
    public String testHttpServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request:" + request.getParameter("name"));
//        System.out.println("response:" + JSON.toJSONString(response));

        return "success";  // 默认使用了请求转发的跳转方式
    }

    //region ModelAndView / ModelMap/ Map/ Model   @SessionAttributes   @ModelAttribute
    //如果跳转时需要带数据:V,M,则可以使用以下几种形式
    // ModelAndView / ModelMap/ Map/ Model  --数据放在requestScope
    //   @SessionAttributes
    //    @ModelAttribute
    @RequestMapping(value = "testModelAndView")
    public ModelAndView testModelAndView() {

        ModelAndView mv = new ModelAndView("success");//也会增加前缀和后缀

        Student stu = new Student();
        stu.setName("xdz");
        stu.setAge(22);
        mv.addObject("student", stu);//相当于request.setAttribute("student",stu)

        return mv;
    }

    @RequestMapping(value = "testModelMap")
    public String testModelMap(ModelMap map) {

        Student stu = new Student();
        stu.setName("xdz");
        stu.setAge(23);
        map.addAttribute("student", stu);
        return "success";
    }

    @RequestMapping(value = "testMap")
    public String testMap(Map map) {

        Student stu = new Student();
        stu.setName("xdz");
        stu.setAge(24);
        map.put("student", stu);
        return "success";
    }

    @RequestMapping(value = "testModel")
    public String testModel(Model model) {

        Student stu = new Student();
        stu.setName("xdz");
        stu.setAge(25);
        model.addAttribute("student", stu);
        return "success";
    }

    @RequestMapping(value = "testSessionAttributes")
    public String testSessionAttributes(Model model) {

        //放开controller上的注释
        Student stu = new Student();
        stu.setName("xdz");
        stu.setAge(25);
        model.addAttribute("student", stu);
        return "success";
    }

    @RequestMapping(value = "testModelAttribute")
    public String testModelAttribute(@ModelAttribute("stu") Student student) {
        System.out.println("student:" + JSON.toJSONString(student));
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @ModelAttribute//在任何请求之前都会请求此注解修饰的方法  在请求该类的方法之前均被执行是基于一个思想:一个controller只做一个功能
    public void queryStudentById(Map<String, Object> map) {
        Student student = new Student();
        student.setName("xdzxdz");
        student.setAge(2511);
        Address address = new Address();
        address.setHomeAddress("asdfas");
        student.setAddress(address);
        map.put("stu", student);
        //map.put("student",student); key值为Student首字母小写,这种方式testModelAttribute方法参数中不需要加@ModelAttribute注解也可以获取到值
        //此方法获取到的值,并不会覆盖前端传过来的值,只会给前端未传的值赋值
    }
    //endregion

    @RequestMapping(value = "testForwardRedirect")
    public String testForward() {

        //return "success";  // 默认使用了请求转发的跳转方式
        //return "forward:/WEB-INF/views/success.jsp";
        return "redirect:/views/success2.jsp"; //不能用WEB-INF下面的

    }


    @RequestMapping(value = "testMyConvert")
    public String testMyConvert(@RequestParam("stu") Student student) {
        System.out.println("student:" + JSON.toJSONString(student));
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @RequestMapping(value = "testMyConvert2")
    public String testMyConvert2(@RequestParam("tea") Teacher teacher) {
        System.out.println("student:" + JSON.toJSONString(teacher));
        return "success";  // 默认使用了请求转发的跳转方式
    }

    @ResponseBody  //告诉springMvc,此时不是返回一个view,而是一个返回值  
    //需要引入    jackson-core   jackson-databind  jackson-annotations    jar
    @RequestMapping(value = "testJson")
    private List<Student> testJson() {
        List<Student> students=new ArrayList<>();
        students.add(new Student("xdz",11,"xxxx"));
        students.add(new Student("xdz222",21,"22xxxx"));
        return students;
    }

}
