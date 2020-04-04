package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.statics;

import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.ITeacher;

public class Teacher implements ITeacher {


    @Override
    public void teach() {
        System.out.println("teacher teach...");
    }
}
