package com.tree.bootroad.v001spring.atguigu.s012di.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    private Car car;

    @Autowired
    public void setCar( Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                '}';
    }
}
