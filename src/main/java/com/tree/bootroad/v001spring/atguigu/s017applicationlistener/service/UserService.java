package com.tree.bootroad.v001spring.atguigu.s017applicationlistener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @EventListener(classes = ApplicationEvent.class)
    public void listen(ApplicationEvent event){
        log.info("event: {}", event);
    }
}
