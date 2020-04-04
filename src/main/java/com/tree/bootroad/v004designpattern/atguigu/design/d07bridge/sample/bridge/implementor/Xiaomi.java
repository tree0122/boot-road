package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor;

public class Xiaomi implements Brand{


    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}
