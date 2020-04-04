package com.tree.bootroad.v004designpattern.atguigu.design.d10facade.sample.composite;

public class Popcorn {

    private static final Popcorn INSTANCE = new Popcorn();

    public static Popcorn getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println(" popcorn on ");
    }

    public void off(){
        System.out.println(" popcorn off ");
    }

    public void pop(){
        System.out.println(" popcorn is poping ");
    }

}
