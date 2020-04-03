package com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.factory.AbstractPizzaFactory;
import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.Pizza;

public class PizzaStage {

    public static void main(String[] args) {
        AbstractPizzaFactory factory = AbstractPizzaFactory.getChinaInstance();
        Pizza pizza = factory.createPizza("china");
    }
}
