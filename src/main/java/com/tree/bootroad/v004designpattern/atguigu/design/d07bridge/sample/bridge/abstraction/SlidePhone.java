package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.abstraction;

import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor.Brand;

public class SlidePhone extends Phone {

    public SlidePhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("滑盖手机");
    }

    public void close(){
        super.close();
        System.out.println("滑盖手机");
    }

    public void call(){
        super.call();
        System.out.println("滑盖手机");
    }

}
