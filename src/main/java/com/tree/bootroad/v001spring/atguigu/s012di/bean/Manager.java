package com.tree.bootroad.v001spring.atguigu.s012di.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {

    private Car car;

    public Manager(Car car) {
        this.car = car;
    }

   /* @Autowired
    public Manager(Car car) {
        this.car = car;
    }

    public Manager(@Autowired Car car) {
        this.car = car;
    }*/

    @Override
    public String toString() {
        return "Manager{" +
                "car=" + car +
                '}';
    }
}
