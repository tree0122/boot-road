package com.tree.bootroad.v001spring.atguigu.s021async.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class CallController {

    @ResponseBody
    @RequestMapping("/call")
    public Callable<String> call(){
        System.out.println("主线程开始: " + Thread.currentThread().getName());
        Callable<String> res = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("工作线程开始: " + Thread.currentThread().getName());
                // doBizMethod();
                String res = "Callable ";
                System.out.println("工作线程结束: " + Thread.currentThread().getName());
                return res;
            }
        };
        System.out.println("主线程结束: " + Thread.currentThread().getName());
        return res;
    }
}
