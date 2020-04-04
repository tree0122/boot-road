package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.abstraction;

import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor.Brand;

public class FlodPhone extends Phone {

    public FlodPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠手机");
    }

    public void close(){
        super.close();
        System.out.println("折叠手机");
    }

    public void call(){
        super.call();
        System.out.println("折叠手机");
    }
}
