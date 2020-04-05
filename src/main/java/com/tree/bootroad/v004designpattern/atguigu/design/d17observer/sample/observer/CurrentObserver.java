package com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer;

public class CurrentObserver implements Observer{

    private double temper;
    private double press;

    @Override
    public void update(double temper, double press) {
        this.temper = temper;
        this.press = press;
        display();
    }

    private void display() {
        System.out.println("today, temper: " + temper + " press: " + press);
    }
}
