package com.tree.bootroad.v004designpattern.atguigu.design.d14command.sample.command;

public class LightOnCommand implements ICommand{

    private LightReceiver receiver;

    public LightOnCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }

    @Override
    public void undo() {
        receiver.off();
    }
}
