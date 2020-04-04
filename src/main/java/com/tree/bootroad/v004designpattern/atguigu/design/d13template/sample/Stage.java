package com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template.AbstractBeanMilk;
import com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template.BlackBeanMilk;
import com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template.RedBeanMilk;

public class Stage {

    public static void main(String[] args) {

        AbstractBeanMilk beanMilk = new BlackBeanMilk();
        beanMilk.make();

        AbstractBeanMilk redBeanMilk = new RedBeanMilk();
        redBeanMilk.make();
    }

}
