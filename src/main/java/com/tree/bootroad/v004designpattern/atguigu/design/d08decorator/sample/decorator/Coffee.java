package com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator;

public class Coffee extends Drink{

    @Override
    public float cost() {
        return super.getPrice();
    }
}
