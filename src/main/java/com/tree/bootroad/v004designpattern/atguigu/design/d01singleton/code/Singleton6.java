package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程安全, 双重检查)
 */
public class Singleton6 {

    private static volatile Singleton6 INSTANCE;

    private Singleton6(){

    }

    public static Singleton6 getInstance(){
        if (INSTANCE == null){
            // synchronized 保证同时只有一个线程在执行
            synchronized (Singleton6.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }

}
