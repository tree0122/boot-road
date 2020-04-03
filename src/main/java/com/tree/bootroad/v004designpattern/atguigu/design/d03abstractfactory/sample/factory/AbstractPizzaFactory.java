package com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.factory;

import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.Pizza;

public abstract class AbstractPizzaFactory {

    public abstract Pizza createPizza(String type);

    public static AbstractPizzaFactory getChinaInstance(){
        return new ChinaPizzaFactory();
    }

    public static AbstractPizzaFactory getEnglishInstance(){
        return new EnglishPizzaFactory();
    }

}
