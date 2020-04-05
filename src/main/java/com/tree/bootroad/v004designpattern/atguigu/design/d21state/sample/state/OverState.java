package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

/**
 * 奖品发完状态, 抽奖结束
 */
public class OverState implements State{

    private Activity activity;

    public OverState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void reduce() {
        System.out.println("奖品发完了, 请下次在参加");
    }

    @Override
    public boolean win() {
        System.out.println("奖品发完了, 请下次在参加");
        return false;
    }

    @Override
    public void issue() {
        System.out.println("奖品发完了, 请下次在参加");
    }

}
