package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

import java.util.Random;

/**
 * 可以抽奖的状态
 */
public class CanState implements State{

    private Activity activity;

    public CanState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void reduce() {
        System.out.println("已扣过积分");
    }

    @Override
    public boolean win() {
        System.out.println("正在抽奖, 请稍等!");
        Random random = new Random();
        int num = random.nextInt(10);
        if (num == 8){
            activity.setState(activity.winState());
            return true;
        }

        System.out.println("很遗憾没有抽中奖品!");
        activity.setState(activity.noCanState());
        return false;
    }

    @Override
    public void issue() {
        System.out.println("没中奖, 不能发放奖品");
    }
}
