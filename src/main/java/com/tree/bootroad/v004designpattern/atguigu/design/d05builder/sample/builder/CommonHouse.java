package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder;

public class CommonHouse extends AbstractHouseBuilder{
    @Override
    public void basic() {
        System.out.println("basic 2m");
    }

    @Override
    public void wall() {
        System.out.println("wall 3m");
    }

    @Override
    public void roof() {
        System.out.println("roof 0.5");
    }
}
