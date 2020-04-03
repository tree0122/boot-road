package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程不安全, 同步代码块)
 */
public class Singleton5 {

    private static Singleton5 INSTANCE;

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        if (INSTANCE == null){
            // 多线程情况下, 这里可能产生多个实例
            synchronized (Singleton5.class){
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }

}
