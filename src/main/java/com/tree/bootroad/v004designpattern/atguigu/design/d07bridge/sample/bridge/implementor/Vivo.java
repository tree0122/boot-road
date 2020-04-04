package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor;

public class Vivo implements Brand{


    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}
