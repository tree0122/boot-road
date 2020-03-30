package com.tree.bootroad.v001spring.atguigu.s021async.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class DeferredController {

    Map<String, DeferredResult> map = new ConcurrentHashMap<>();

    @ResponseBody
    @RequestMapping("/order")
    public DeferredResult<String> order(String id){
        System.out.println("主线程开始: " + Thread.currentThread().getName());
        DeferredResult<String> deferredResult = new DeferredResult<>( 3000L, "Fail");
        map.put(id, deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(String id){
        DeferredResult result = map.remove(id);
        if (result != null){
            result.setResult("success");
        }

        return "success ===> " + id;
    }
}
