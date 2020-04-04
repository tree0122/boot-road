package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class Projector {

    private static final Projector INSTANCE = new Projector();

    public static Projector getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println(" projector on ");
    }

    public void off(){
        System.out.println(" projector off ");
    }

    public void focus(){
        System.out.println(" projector is focus ");
    }

}
