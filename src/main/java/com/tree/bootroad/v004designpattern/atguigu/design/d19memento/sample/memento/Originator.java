package com.tree.bootroad.v004designpattern.atguigu.design.d19memento.sample.memento;

public class Originator {

    private String state;

    public Memento saveState(){
        return new Memento(state);
    }

    public void setStateFromMemento(Memento memento){
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
