package com.tree.bootroad.v004designpattern.atguigu.design.d13template.sample.template;

public abstract class AbstractBeanMilk {

    public final void make(){
        select();
        add();
        soak();
        beat();
        well();
    }

    protected abstract void select();

    protected abstract void add();

    protected abstract void soak();

    protected abstract void beat();

    // 钩子方法
    protected void well(){

    }
}
