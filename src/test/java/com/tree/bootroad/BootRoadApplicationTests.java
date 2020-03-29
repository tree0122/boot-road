package com.tree.bootroad;

import com.tree.bootroad.x003bean.multi.ServiceList;
import com.tree.bootroad.x004event.ContentEvent;
import com.tree.bootroad.x005guavaeventbus.GuavaEventBus;
import com.tree.bootroad.x008customstarter.ExampleServiceUse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootRoadApplicationTests {

    @Resource
    private ServiceList serviceList;

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private ExampleServiceUse exampleServiceUse;

    @Test
    public void aop1() {

    }

    @Test
    public void multiBean(){
        serviceList.printSize();
    }

    @Test
    public void event(){
        applicationContext.publishEvent(new ContentEvent("sth update"));
    }

    @Resource
    private GuavaEventBus guavaEventBus;

    @Test
    public void eventBus(){
        guavaEventBus.biz();
    }

    @Test
    public void customStarter(){
        exampleServiceUse.wrap("tee");
    }

}

