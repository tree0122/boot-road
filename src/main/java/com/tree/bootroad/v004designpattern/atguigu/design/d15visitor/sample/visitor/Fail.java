package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor;


public class Fail extends Action{
    @Override
    public void manResult(Person person) {
        System.out.println("man fail");
    }

    @Override
    public void womanResult(Person person) {
        System.out.println("woman fail");
    }
}
