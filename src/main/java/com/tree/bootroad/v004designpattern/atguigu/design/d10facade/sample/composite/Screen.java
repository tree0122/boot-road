package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class Screen {

    private static final Screen INSTANCE = new Screen();

    public static Screen getInstance(){
        return INSTANCE;
    }

    public void up(){
        System.out.println(" screen up ");
    }

    public void down(){
        System.out.println(" screen down ");
    }

}
