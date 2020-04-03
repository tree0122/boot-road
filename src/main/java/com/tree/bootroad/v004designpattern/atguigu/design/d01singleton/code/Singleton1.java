package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 静态常亮
 */
public class Singleton1 {

    private final static  Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

}
