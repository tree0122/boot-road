package com.tree.bootroad.v004designpattern.atguigu.design.d23chain.sample.chain;

public abstract class Approve {

    private String name;

    private Approve approve;

    public Approve(String name) {
        this.name = name;
    }

    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    public String getName() {
        return name;
    }

    public Approve getApprove() {
        return approve;
    }

    public abstract void handle(Request request);
}
