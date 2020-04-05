package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

public class TVColleague extends Colleague{

    public TVColleague(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, this.getName());
    }

    public void start(){
        System.out.println("It's time to start TV!");
    }

    public void stop(){
        System.out.println("It's time to stop TV!");
    }

}
