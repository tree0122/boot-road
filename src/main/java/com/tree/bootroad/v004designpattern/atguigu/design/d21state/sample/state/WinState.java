package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

/**
 * 发奖状态
 */
public class WinState implements State{

    private Activity activity;

    public WinState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void reduce() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean win() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void issue() {
        if (activity.getCount() > 0){
            activity.decreaseCount();
            System.out.println("恭喜您中奖了!");
            activity.setState(activity.noCanState());
        }else {
            System.out.println("很抱歉, 奖品已发完");
            activity.setState(activity.overState());
        }
    }
}
