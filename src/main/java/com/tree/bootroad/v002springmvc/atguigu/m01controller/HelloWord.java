package com.tree.bootroad.v002springmvc.atguigu.m01controller;

import com.tree.bootroad.v002springmvc.atguigu.m01controller.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HelloWord {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        System.out.println("PathVariable " + id);
        return "hi";
    }

    @RequestMapping("/get/{id}")
    public String get(
            @PathVariable("id") int id,
            @RequestParam("name") String name,
            @RequestHeader("Accept-Language") String lang,
            @CookieValue("JSESSIONID") String sessionId
    ){
        System.out.println("PathVariable " + id);
        return "hi";
    }

    /**
     * 请求参数名和POJO属性名进行自动匹配, 自动为该对象填充属性值
     * 支持级联, 如: address.city
     *
     * 参数如: name=tree&age=18&address.city=xiangyang&address.province=hubei
     * @param user
     * @return
     */
    @RequestMapping("/pojo")
    public String pojo(User user){
        System.out.println(user);
        return "user";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView mv = new ModelAndView("model");
        mv.addObject("time", new Date());

        return mv;
    }
}
