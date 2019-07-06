package com.tree.bootroad.x007servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Configuration
@ServletComponentScan
public class ServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/my/ser");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new MyListener());
        return bean;
    }

    /**
     * 自定义servlet
     */
    public static class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
            log.info("myServlet1 doGet.....");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("myServlet1 doPost.....");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>hello, my name is Servlet 1</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @WebServlet(urlPatterns = "/my/ser2", description = "my servlet2 的说明")
    public static class MyServlet2 extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("MyServlet2 doGet.....");
            doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("MyServlet2 doPost.....");
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>hello, my name is Servlet2</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * 自定义servlet规范的Listener
     */
    public static class MyListener implements ServletContextListener{
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            log.info("MyListener contextInitialized ....");
        }
    }

}
