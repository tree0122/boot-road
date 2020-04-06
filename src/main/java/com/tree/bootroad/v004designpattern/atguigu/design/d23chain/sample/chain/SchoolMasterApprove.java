package com.tree.bootroad.v004designpattern.atguigu.design.d23chain.sample.chain;

public class SchoolMasterApprove extends Approve {

    public SchoolMasterApprove(String name) {
        super(name);
    }

    @Override
    public void handle(Request request) {
        if (request.getPrice() <= 30000){
            System.out.println("请求编号id = " + request.getId() + " 由 " + getName() + " 处理");
        }else {
            getApprove().handle(request);
        }
    }
}
