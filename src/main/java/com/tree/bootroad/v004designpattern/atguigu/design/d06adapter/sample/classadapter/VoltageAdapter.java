package com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.classadapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int src = output220V();
        return src / 44;
    }
}
