package com.tree.bootroad;

import com.tree.bootroad.x002aop.service.EntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootRoadApplicationTests {

    @Resource
    private EntityService entityService;

    @Test
    public void aop1() {
        entityService.save("tree");
        System.out.println("-----------------------------------");
        entityService.get("cui");
    }

}

