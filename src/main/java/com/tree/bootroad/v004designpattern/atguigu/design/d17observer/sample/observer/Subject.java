package com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
