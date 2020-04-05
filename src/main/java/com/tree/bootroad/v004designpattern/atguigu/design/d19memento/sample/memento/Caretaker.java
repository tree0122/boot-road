package com.tree.bootroad.v004designpattern.atguigu.design.d19memento.sample.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int idx){
        return mementoList.get(idx);
    }

}
