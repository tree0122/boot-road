package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder;

public class HighBuildingHouse extends AbstractHouseBuilder{
    @Override
    public void basic() {
        System.out.println("basic 10m");
    }

    @Override
    public void wall() {
        System.out.println("wall 2.5m");
    }

    @Override
    public void roof() {
        System.out.println("roof 0.4");
    }
}
