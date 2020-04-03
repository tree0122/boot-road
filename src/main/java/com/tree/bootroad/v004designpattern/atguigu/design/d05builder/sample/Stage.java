package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder.CommonHouse;
import com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.builder.Director;

public class Stage {

    public static void main(String[] args) {
        Director director = new Director(new CommonHouse());
        director.build();
    }

}
