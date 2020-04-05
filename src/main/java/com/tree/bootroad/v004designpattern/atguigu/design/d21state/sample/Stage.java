package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state.Activity;

public class Stage {

    public static void main(String[] args) {
        Activity activity = new Activity(1);
        for (int i = 1; i <= 30; i++) {
            System.out.println("---------第" + i + "次抽奖--------");
            // 扣积分
            activity.reduce();
            // 开始抽奖
            activity.win();
        }
    }

}
