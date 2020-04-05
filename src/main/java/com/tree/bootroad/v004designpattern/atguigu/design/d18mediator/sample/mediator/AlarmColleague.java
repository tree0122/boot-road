package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

public class AlarmColleague extends Colleague{

    public AlarmColleague(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange, this.getName());
    }

    public void sendAlarm(int stageChange){
        sendMessage(stageChange);
    }

}
