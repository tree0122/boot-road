package com.tree.bootroad.multibean;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class MultiService {
    @Resource
    private List<Service0> service0List;

    private void init(){
        log.info("service0List: {}", service0List);
    }

}
