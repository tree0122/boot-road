package com.tree.bootroad.v004designpattern.atguigu.design.d14command.sample.command;

public class LightOffCommand implements ICommand{

    private LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.off();
    }

    @Override
    public void undo() {
        receiver.on();
    }
}
