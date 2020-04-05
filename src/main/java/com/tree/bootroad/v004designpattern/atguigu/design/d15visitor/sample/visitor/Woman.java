package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor;


public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.womanResult(this);
    }
}
