package com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator.Drink;
import com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator.LongCoffee;
import com.tree.bootroad.v004designpattern.atguigu.design.d08decorator.sample.decorator.MilkDecorator;

public class Stage {

    public static void main(String[] args) {
        Drink order = new LongCoffee();
        System.out.println("cos1: " + order.cost());
        System.out.println("des1: " + order.getDesc());

        order = new MilkDecorator(order);
        System.out.println("cos2, plus milk: " + order.cost());
        System.out.println("des2, plus milk: " + order.getDesc());
    }

}
