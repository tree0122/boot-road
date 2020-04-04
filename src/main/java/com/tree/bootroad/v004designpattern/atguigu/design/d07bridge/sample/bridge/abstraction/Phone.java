package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.abstraction;

import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor.Brand;

/**
 * 桥接类
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }

    public void close(){
        brand.close();
    }

    public void call(){
        brand.call();
    }
}
