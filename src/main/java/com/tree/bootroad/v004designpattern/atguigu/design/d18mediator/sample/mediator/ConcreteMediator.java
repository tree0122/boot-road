package com.tree.bootroad.v004designpattern.atguigu.design.d18mediator.sample.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator extends Mediator{
    private Map<String, Colleague> colleagueMap;
    private Map<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if (colleague instanceof AlarmColleague){
            interMap.put("alarm", colleagueName);
        }else if (colleague instanceof TVColleague){
            interMap.put("TV", colleagueName);
        }else if (colleague instanceof CurtainsColleague){
            interMap.put("curtains", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        Colleague colleague = colleagueMap.get(colleagueName);
        if (colleague instanceof AlarmColleague){
            if (stateChange == 0){
                ((TVColleague) colleagueMap.get(interMap.get("TV"))).start();
            }else if (stateChange == 1){
                ((TVColleague) colleagueMap.get(interMap.get("TV"))).stop();
            }
        }else if (colleague instanceof TVColleague){

        }
    }

    @Override
    public void sendMessage() {

    }

}
