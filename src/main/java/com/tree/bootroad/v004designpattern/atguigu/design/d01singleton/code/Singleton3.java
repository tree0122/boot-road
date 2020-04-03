package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程不安全)
 */
public class Singleton3 {

    private static Singleton3 INSTANCE;

    private Singleton3(){

    }

    public static Singleton3 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }

}
