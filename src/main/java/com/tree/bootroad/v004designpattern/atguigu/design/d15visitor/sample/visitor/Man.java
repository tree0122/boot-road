package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor;


public class Man extends Person {

    @Override
    public void accept(Action action) {
        action.manResult(this);
    }
}
