package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

public class CurtainsColleague extends Colleague{

    public CurtainsColleague(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, this.getName());
    }

    public void upCurtains(){
        System.out.println("I am holding up curtains!");
    }

}
