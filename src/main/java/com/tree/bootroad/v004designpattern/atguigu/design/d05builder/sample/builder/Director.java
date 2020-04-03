package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder;

public class Director {
    AbstractHouseBuilder houseBuilder;

    public Director(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House build(){
        houseBuilder.basic();
        houseBuilder.wall();
        houseBuilder.roof();
        return houseBuilder.build();
    }
}
