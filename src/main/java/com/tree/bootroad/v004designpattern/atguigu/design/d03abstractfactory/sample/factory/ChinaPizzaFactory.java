package com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.factory;

import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.ChinaPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.Pizza;

public class ChinaPizzaFactory extends AbstractPizzaFactory{

    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println("china factory");
        switch (type){
            case "china":
                pizza = new ChinaPizza();
                break;
        }
        return pizza;
    }

}
