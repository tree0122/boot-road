package com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template;

public class RedBeanMilk extends AbstractBeanMilk{

    @Override
    protected void select() {
        System.out.println("select red bean");
    }

    @Override
    protected void add() {
        System.out.println("add red bean");
    }

    @Override
    protected void soak() {
        System.out.println("soak red bean");
    }

    @Override
    protected void beat() {
        System.out.println("beat red bean");
    }

    @Override
    protected void well() {
        System.out.println("red is very good!");
    }
}
