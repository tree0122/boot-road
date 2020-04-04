package com.tree.bootroad.v004designpattern.atguigu.design.d11flyweight.sample.flyweight;

public class ConcreteWebSite extends WebSite{

    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("website, type: " + type);
    }
}
