package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator.*;

public class Stage {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        AlarmColleague alarm = new AlarmColleague(mediator, "alarm");
        CurtainsColleague curtains = new CurtainsColleague(mediator, "curtains");
        TVColleague tv = new TVColleague(mediator, "TV");

        alarm.sendAlarm(0);
        alarm.sendAlarm(1);
    }

}
