package com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.classadapter.Phone;
import com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.classadapter.VoltageAdapter;
import com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.interfaceadapter.AbstractService;
import com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.interfaceadapter.ServiceAdapter;
import com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.objectadapter.Voltage220V;

public class Stage {

    public static void main(String[] args) {
        cAdapter();
    }

    private static void cAdapter(){
        System.out.println("==========类适配器模式");

        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }

    private static void oAdapter(){
        System.out.println("==========对象适配器模式");

        Phone phone = new Phone();
//        phone.charging(new VoltageAdapter(new Voltage220V()));
    }

    private static void iAdapter(){
        System.out.println("==========接口适配器模式");

        AbstractService abstractService = new ServiceAdapter();
        abstractService.m1();
    }

}
