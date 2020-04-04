package com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite;

public class DepartmentLeaf extends OrgComponent{

    public DepartmentLeaf(String name, String des) {
        super(name, des);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }

}
