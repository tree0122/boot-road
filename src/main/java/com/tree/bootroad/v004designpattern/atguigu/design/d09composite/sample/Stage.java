package com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite.CollegeComposite;
import com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite.DepartmentLeaf;
import com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite.OrgComponent;
import com.tree.bootroad.v004designpattern.atguigu.design.d09composite.sample.composite.UniversityComposite;

public class Stage {

    public static void main(String[] args) {

        OrgComponent university = new UniversityComposite("清华", "顶级大学");

        OrgComponent cs = new CollegeComposite("计算机", "计算机科学");
        OrgComponent auto = new CollegeComposite("自动化", "自动化");

        cs.add(new DepartmentLeaf("软件工程", "软件编写"));
        cs.add(new DepartmentLeaf("网络工程", "网络编写"));

        auto.add(new DepartmentLeaf("电力", "比较难"));
        auto.add(new DepartmentLeaf("自动化", "非常难"));

        university.add(cs);
        university.add(auto);

        university.print();
    }

}
