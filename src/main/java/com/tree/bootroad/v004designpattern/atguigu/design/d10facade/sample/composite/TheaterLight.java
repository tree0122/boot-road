package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class TheaterLight {

    private static final TheaterLight INSTANCE = new TheaterLight();

    public static TheaterLight getInstance(){
        return INSTANCE;
    }

    public void dim(){
        System.out.println(" TheaterLight dim ");
    }

    public void bright(){
        System.out.println(" TheaterLight bright ");
    }

    public void on(){
        System.out.println(" TheaterLight on ");
    }
    public void off(){
        System.out.println(" TheaterLight off ");
    }

}
