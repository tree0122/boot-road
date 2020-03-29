package com.tree.bootroad.v001spring.atguigu.s012di.bean;

import org.springframework.stereotype.Component;

@Component
public class Boss {

    private Car car;

    private Manager manager;

    public Boss(Car car, Manager manager) {
        this.car = car;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", manager=" + manager +
                '}';
    }
}
