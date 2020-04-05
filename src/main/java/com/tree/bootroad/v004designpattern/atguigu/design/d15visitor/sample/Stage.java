package com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d15visitor.sample.visitor.*;

public class Stage {

    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.add(new Man());
        structure.add(new Man());
        structure.add(new Woman());

        structure.display(new Success());
        structure.display(new Fail());
    }

}
