package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

/**
 * 不能抽奖状态
 */
public class NoCanState implements State{

    private Activity activity;

    public NoCanState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void reduce() {
        System.out.println("已扣除50积分, 您可以抽奖了");
        activity.setState(activity.canState());
    }

    @Override
    public boolean win() {
        System.out.println("扣了积分才能抽奖");
        return false;
    }

    @Override
    public void issue() {
        System.out.println("不能发放奖品");
    }
}
