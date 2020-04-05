package com.tree.bootroad.v004designpattern.atguigu.design.d21state.sample.state;

public class Activity implements Context{
    private State noCan = new CanState(this);
    private State can = new NoCanState(this);
    private State win = new WinState(this);
    private State over = new OverState(this);

    // 活动当前状态
    private State state;

    // 奖品数量
    private int count;

    public Activity(int count) {
        this.state = noCan;
        this.count = count;
    }

    // 扣积分
    public void reduce(){
        state.reduce();
    }

    // 抽奖
    public void win(){
        // 当前状态抽奖成功
        if (state.win()){
            // 领奖
            state.issue();
        }
    }

    public void setState(State state){
        this.state = state;
    }

    public State canState(){
        return can;
    }

    public State winState(){
        return win;
    }

    public State noCanState() {
        return noCan;
    }

    public State overState() {
        return over;
    }

    public int getCount() {
        return count;
    }

    public void decreaseCount(){
        count--;
    }
}
