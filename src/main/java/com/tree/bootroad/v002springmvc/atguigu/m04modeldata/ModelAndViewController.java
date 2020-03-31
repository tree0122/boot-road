package com.tree.bootroad.v002springmvc.atguigu.m04modeldata;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
@RequestMapping("/mv")
public class ModelAndViewController {

    private static String SUCCESS = "success";

    @RequestMapping("/mv")
    public ModelAndView modelAndView(){
        ModelAndView mv = new ModelAndView(SUCCESS);
        mv.addObject("time", new Date());

        return mv;
    }

    @RequestMapping(value = {"/map", "/model"})
    public String mapOrMode(Map<String, Object> map){
        map.put("name", "tree");

        return SUCCESS;
    }

    @RequestMapping("/sessionAttribute")
    public String sessionAttribute(Map<String, Object> map){
        map.put("user", new Person(1, 18, "tree", "passw")); // value属性名
        map.put("addr", "xiangyang");   // type属性对象
        return SUCCESS;
    }

    /**
     * 入参 id=1&age=18&name=nee
     * @param person
     * @return
     */
    @RequestMapping("/modelAttribute")
    public String modelAttribute(Person person){
        System.out.println("update: " + person);
        return SUCCESS;
    }

    @ModelAttribute
    public void getPerson(@RequestParam("id") Integer id, Map<String, Object> map){
        System.out.println("ModelAttribute method...");
        if (id != null){
            // 模拟从db获取对象
            Person person = new Person(id, 20, "tree", "passw");
            System.out.println("in db: " + person);
            map.put("person", person);
        }
    }



}
