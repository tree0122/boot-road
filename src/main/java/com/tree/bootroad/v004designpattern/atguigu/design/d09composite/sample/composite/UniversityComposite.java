package com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite;

import java.util.ArrayList;
import java.util.List;

public class UniversityComposite extends OrgComponent{

    List<OrgComponent> colleges = new ArrayList<>();

    public UniversityComposite(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(OrgComponent component) {
        colleges.add(component);
    }

    @Override
    public void remove(OrgComponent component) {
        colleges.remove(component);
    }

    @Override
    public void print() {
        System.out.println("-----------" + getName() + "---------");
        for (OrgComponent org : colleges) {
            org.print();
        }
    }
}
