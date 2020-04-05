package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

public interface State {

    // 扣出积分
    void reduce();

    // 是否抽中奖品
    boolean win();

    //  发放奖品
    void issue();
}
