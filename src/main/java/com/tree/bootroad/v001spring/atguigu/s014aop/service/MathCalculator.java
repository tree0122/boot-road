package com.tree.bootroad.v001spring.atguigu.s014aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MathCalculator {

    public int div(int i, int j){
        log.info("params: i = {}, j = {}", i, j);
        return i / j;
    }

}
