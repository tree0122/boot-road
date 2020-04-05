package com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements Subject{

    private double temper;
    private double press;
    private List<Observer> observers;

    public WeatherSubject() {
        this.observers = new ArrayList<>();
    }

    public void setData(double temper, double press){
        this.temper = temper;
        this.press = press;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temper, press);
        }
    }
}
