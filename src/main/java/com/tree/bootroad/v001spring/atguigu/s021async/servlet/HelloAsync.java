package com.tree.bootroad.v001spring.atguigu.s021async.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. asyncSupported = true: 支持异步处理
 */
@WebServlet(value = "/hello", asyncSupported = true)
public class HelloAsync extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程开始: " + Thread.currentThread().getName());
        // 2. 开启异步模式
        AsyncContext asyncContext = req.startAsync();

        // 3. 业务逻辑开始异步处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("工作线程开始: " + Thread.currentThread().getName());
                // doBizMethod();
                asyncContext.complete();

                // 4. 获取响应
                try {
                    asyncContext.getResponse().getWriter().write("hell async....");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("工作线程结束: " + Thread.currentThread().getName());
            }
        });

        System.out.println("主线程结束: " + Thread.currentThread().getName());
    }

}
