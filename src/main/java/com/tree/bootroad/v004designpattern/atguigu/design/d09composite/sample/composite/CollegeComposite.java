package com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite;

import java.util.ArrayList;
import java.util.List;

public class CollegeComposite extends OrgComponent{

    List<OrgComponent> departments = new ArrayList<>();

    public CollegeComposite(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrgComponent component) {
        departments.add(component);
    }

    @Override
    public void remove(OrgComponent component) {
        departments.remove(component);
    }

    @Override
    public void print() {
        System.out.println("-----------" + getName() + "---------");
        for (OrgComponent org : departments) {
            org.print();
        }
    }
}
