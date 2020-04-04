package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.ITeacher;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.cglib.CglibProxyFactory;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.cglib.TargetTeacher;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.interfaces.JTargetTeacher;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.interfaces.JdkProxyFactory;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.statics.Teacher;
import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.statics.TeacherProxy;

public class Stage {

    public static void main(String[] args) {
        staticProxy();
    }

    private static void staticProxy(){
        ITeacher proxy = new TeacherProxy(new Teacher());

        proxy.teach();
    }

    private static void interfaceProxy(){
        JTargetTeacher jTargetTeacher = new JTargetTeacher();
        ITeacher proxyInstance = new JdkProxyFactory(jTargetTeacher).getProxy();
        proxyInstance.teach();

        System.out.println("proxyInstance = " + proxyInstance.getClass());

    }

    private static void cglibProxy(){
        TargetTeacher targetTeacher = new TargetTeacher();
        TargetTeacher proxyInstance = new CglibProxyFactory(targetTeacher).getProxy();

        proxyInstance.teach();
    }

}
