package com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator;

public class ChocolateDecorator extends Decorator {

    public ChocolateDecorator(Drink obj) {
        super(obj);
        setDesc("chocolate");
        setPrice(3.0f);
    }

}
