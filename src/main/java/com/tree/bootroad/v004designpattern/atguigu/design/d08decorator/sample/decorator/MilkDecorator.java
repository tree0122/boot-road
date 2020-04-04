package com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator;

public class MilkDecorator extends Decorator {

    public MilkDecorator(Drink obj) {
        super(obj);
        setDesc("milk");
        setPrice(2.0f);
    }

}
