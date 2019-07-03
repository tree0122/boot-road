package com.tree.bootroad.x003bean.multi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ServiceList {

    @Resource
    List<ResourceService> resourceServiceList;

    public void printSize(){
      log.info("resourceService size: {}", resourceServiceList.size());
    }
}
