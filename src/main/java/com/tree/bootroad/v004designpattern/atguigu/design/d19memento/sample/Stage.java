package com.tree.bootroad.v004designpattern.atguigu.design.d19memento.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d19memento.sample.memento.Caretaker;
import com.tree.bootroad.v004designpattern.atguigu.design.d19memento.sample.memento.Originator;

public class Stage {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("状态#1 攻击力100");
        caretaker.add(originator.saveState());

        originator.setState("状态#3 攻击力80");
        caretaker.add(originator.saveState());

        System.out.println("当前状态: " + originator.getState());

        // 回到状态1
        originator.setStateFromMemento(caretaker.get(0));
    }

}
