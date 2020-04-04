package com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.abstraction.FlodPhone;
import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.abstraction.Phone;
import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor.Vivo;
import com.tree.bootroad.v004designpattern.atguigu.design.d07bridge.sample.bridge.implementor.Xiaomi;

public class Stage {

    public static void main(String[] args) {
        Phone phone1 = new FlodPhone(new Xiaomi());
        phone1.open();
        phone1.call();
        phone1.close();

        System.out.println("================");

        Phone phone2 = new FlodPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();

    }

}
