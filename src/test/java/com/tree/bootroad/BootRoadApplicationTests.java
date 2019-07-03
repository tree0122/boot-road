package com.tree.bootroad;

import com.tree.bootroad.x002aop.service.EntityService;
import com.tree.bootroad.x003bean.multi.ServiceList;
import com.tree.bootroad.x004event.ContentEvent;
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
    private EntityService entityService;

    @Resource
    private ServiceList serviceList;

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void aop1() {
        entityService.save("tree");
        System.out.println("-----------------------------------");
        entityService.get("cui");
        System.out.println("-----------------------------------");
        entityService.log("give");
    }

    @Test
    public void multiBean(){
        serviceList.printSize();
    }

    @Test
    public void event(){
        applicationContext.publishEvent(new ContentEvent("sth update"));
    }
}

