package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程安全, 同步方法)
 */
public class Singleton4 {

    private static Singleton4 INSTANCE;

    private Singleton4(){

    }

    public static synchronized Singleton4 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }

}
