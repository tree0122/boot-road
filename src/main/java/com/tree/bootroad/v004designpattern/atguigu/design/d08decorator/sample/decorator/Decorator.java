package com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator;

public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDesc() {
        return getDesc() + getPrice() + " && " + obj.getDesc();
    }
}
