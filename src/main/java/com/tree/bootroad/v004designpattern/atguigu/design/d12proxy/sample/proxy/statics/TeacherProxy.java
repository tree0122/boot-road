package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.statics;

import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.ITeacher;

public class TeacherProxy implements ITeacher {

    private ITeacher target;

    public TeacherProxy(ITeacher target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("proxy start...");
        target.teach();
        System.out.println("proxy end");
    }
}
