package com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.factory;

import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.pizza.ChessPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.pizza.ChinaPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.pizza.GreekPizza;
import com.tree.bootroad.v004designpattern.atguigu.design.d02factory.sample.pizza.Pizza;

public class PizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;
        System.out.println("simple factory");
        switch (type){
            case "chess":
                pizza = new ChessPizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
            case "china":
                pizza = new ChinaPizza();
                break;
        }
        return pizza;
    }

    public static PizzaFactory getInstance(){
        return new PizzaFactory();
    }

}
