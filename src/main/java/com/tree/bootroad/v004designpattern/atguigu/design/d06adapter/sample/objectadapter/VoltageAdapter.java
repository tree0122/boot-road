package com.tree.bootroad.v004designpattern.atguigu.design.d06adapter.sample.objectadapter;

public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int src = voltage220V.output220V();
        return src / 44;
    }
}
