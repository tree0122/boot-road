package com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template;

public class BlackBeanMilk extends AbstractBeanMilk{

    @Override
    protected void select() {
        System.out.println("select black bean");
    }

    @Override
    protected void add() {
        System.out.println("add black bean");
    }

    @Override
    protected void soak() {
        System.out.println("soak black bean");
    }

    @Override
    protected void beat() {
        System.out.println("beat black bean");
    }

}
