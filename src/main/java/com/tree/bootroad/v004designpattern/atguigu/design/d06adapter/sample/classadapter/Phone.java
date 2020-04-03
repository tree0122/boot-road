package com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.classadapter;

public class Phone {

    public void charging(IVoltage5V voltage5V){
        int voltage = voltage5V.output5V();
        if (voltage == 5){
            System.out.println("可充电...");
        }else if (voltage > 5){
            System.out.println("电压过高, 不能充电...");
        }
    }
}
