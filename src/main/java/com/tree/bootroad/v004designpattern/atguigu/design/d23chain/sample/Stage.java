package com.tree.bootroad.v004designpattern.atguigu.design.d23chain.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d23chain.sample.chain.*;

public class Stage {

    public static void main(String[] args) {
        Request request = new Request(1, 6000, 10);

        Approve department = new DepartmentApprove("张主任");
        Approve college = new CollegeApprove("李院长");
        Approve master = new SchoolMasterApprove("王校长");

        department.setApprove(college);
        college.setApprove(master);
        master.setApprove(department);

        // 两次调用会给同一个 Approve 处理
        department.handle(request);
        master.handle(request);
    }

}
