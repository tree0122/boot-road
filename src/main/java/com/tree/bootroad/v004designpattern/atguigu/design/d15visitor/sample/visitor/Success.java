package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor;


public class Success extends Action{
    @Override
    public void manResult(Person person) {
        System.out.println("man success");
    }

    @Override
    public void womanResult(Person person) {
        System.out.println("woman success");
    }
}
