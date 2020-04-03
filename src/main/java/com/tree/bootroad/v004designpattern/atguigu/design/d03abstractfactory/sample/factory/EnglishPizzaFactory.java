package com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.factory;

import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.ChessPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.ChinaPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.GreekPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d03abstractfactory.sample.pizza.Pizza;

public class EnglishPizzaFactory extends AbstractPizzaFactory{

    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println("english factory");
        switch (type){
            case "chess":
                pizza = new ChessPizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
        }
        return pizza;
    }

}
