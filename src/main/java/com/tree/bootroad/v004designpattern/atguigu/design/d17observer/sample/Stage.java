package com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer.BaiduObserver;
import com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer.CurrentObserver;
import com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer.Observer;
import com.tree.bootroad.v004designpattern.atguigu.design.d17observer.sample.observer.WeatherSubject;

public class Stage {

    public static void main(String[] args) {
        WeatherSubject weatherSubject = new WeatherSubject();

        Observer currentObserver = new CurrentObserver();

        weatherSubject.registerObserver(currentObserver);
        weatherSubject.registerObserver(new BaiduObserver());

        System.out.println("------------");
        weatherSubject.setData(30.4, 101.1);
    }

}
