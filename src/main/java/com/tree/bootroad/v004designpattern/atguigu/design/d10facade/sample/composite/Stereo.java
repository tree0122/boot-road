package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class Stereo {

    private static final Stereo INSTANCE = new Stereo();

    public static Stereo getInstance(){
        return INSTANCE;
    }

    public void up(){
        System.out.println(" stereo up ");
    }

    public void down(){
        System.out.println(" stereo down ");
    }

    public void on(){
        System.out.println(" stereo on ");
    }
    public void off(){
        System.out.println(" stereo off ");
    }

}
