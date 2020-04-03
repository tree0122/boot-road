package com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d05builder.sample.prototype.Sheep;

public class Stage {

    public static void main(String[] args) {
        Sheep sheep = new Sheep(1, "tome", "white");

        for (int i = 0; i < 5; i++) {
            Sheep clone = sheep.clone();
            System.out.println(clone.hashCode() + " --- " + clone);
        }
    }
}
