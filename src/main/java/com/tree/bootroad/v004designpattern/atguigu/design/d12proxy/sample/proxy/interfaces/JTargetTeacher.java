package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.interfaces;

import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.ITeacher;

public class JTargetTeacher implements ITeacher {

    @Override
    public void teach() {
        System.out.println("interface target teacher teach...");
    }
}
