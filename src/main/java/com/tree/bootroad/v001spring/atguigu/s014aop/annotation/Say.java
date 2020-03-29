package com.tree.bootroad.v001spring.atguigu.s014aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Say {

    @Mark
    public Object echo(Object o){
        log.info("echo params: {}", o);
        return o;
    }
}
