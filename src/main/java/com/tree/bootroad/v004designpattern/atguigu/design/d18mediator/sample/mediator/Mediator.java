package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

public abstract class Mediator {

    public abstract void register(String colleagueName, Colleague colleague);

    public abstract void getMessage(int stateChange, String colleagueName);

    public abstract void sendMessage();
}
