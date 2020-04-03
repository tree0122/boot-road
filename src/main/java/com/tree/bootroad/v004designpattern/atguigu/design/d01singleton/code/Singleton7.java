package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程安全, 静态内部类)
 */
public class Singleton7 {

    private Singleton7(){

    }

    public static Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

}
