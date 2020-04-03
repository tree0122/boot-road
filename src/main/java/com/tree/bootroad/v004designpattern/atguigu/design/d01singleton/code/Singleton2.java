package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 静态代码块
 */
public class Singleton2 {

    private final static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return INSTANCE;
    }

}
