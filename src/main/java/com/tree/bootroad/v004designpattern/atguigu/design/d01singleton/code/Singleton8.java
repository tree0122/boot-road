package com.tree.bootroad.v004designpattern.atguigu.design.d01singleton.code;

/**
 * 懒汉式(线程安全, 静态内部类)
 */
public enum  Singleton8 {

    INSTANCE;

    public void ok(){
        System.out.println("ok...");
    }
}
