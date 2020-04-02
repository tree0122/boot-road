package com.tree.bootroad.v003springboot.atguigu.listener;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    @Override
    public void starting() {
        System.out.println("MySpringApplicationRunListener...starting()");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener...environmentPrepared()");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener...contextPrepared()");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener...contextLoaded()");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener...started()");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener...running()");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener...failed()");
    }
}
