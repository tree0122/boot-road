package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder;

public abstract class AbstractHouseBuilder {
    protected House house = new House();

    public abstract void basic();

    public abstract void wall();

    public abstract void roof();

    public House build(){
        return house;
    }

}
