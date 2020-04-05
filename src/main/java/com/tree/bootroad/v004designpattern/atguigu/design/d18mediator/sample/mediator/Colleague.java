package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

public abstract class Colleague {

    private Mediator mediator;
    private String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return this.mediator;
    }

    public String getName() {
        return name;
    }

    public abstract void sendMessage(int stateChange);

}
