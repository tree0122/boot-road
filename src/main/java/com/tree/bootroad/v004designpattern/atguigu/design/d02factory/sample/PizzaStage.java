package com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.factory.PizzaFactory;
import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.pizza.Pizza;

public class PizzaStage {

    public static void main(String[] args) {
        PizzaFactory factory = PizzaFactory.getInstance();
        Pizza chess = factory.createPizza("chess");
    }
}
