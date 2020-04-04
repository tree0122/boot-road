package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class DVDPlayer {

    private static final DVDPlayer INSTANCE = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println(" dvd on ");
    }

    public void off(){
        System.out.println(" dvd off ");
    }

    public void play(){
        System.out.println(" dvd play ");
    }

    public void pause(){
        System.out.println(" dvd pause ");
    }

}
