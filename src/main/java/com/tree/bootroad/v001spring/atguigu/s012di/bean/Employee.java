package com.tree.bootroad.v001spring.atguigu.s012di.bean;

public class Employee {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "car=" + car +
                '}';
    }
}
