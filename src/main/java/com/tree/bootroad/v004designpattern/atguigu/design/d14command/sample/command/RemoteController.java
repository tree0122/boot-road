package com.tree.bootroad.v004designpattern.atguigu.design.d14command.sample.command;

public class RemoteController {

    ICommand[] onCommand;
    ICommand[] offCommand;

    ICommand undoCommand = new NoCommand();

    public RemoteController() {
        this.onCommand = new NoCommand[5];
        this.offCommand = new NoCommand[5];
        for (int i = 0; i < this.onCommand.length; i++) {
            this.onCommand[i] = this.offCommand[i] = new NoCommand();
        }
    }

    public void onButton(int no){
        onCommand[no].execute();
        undoCommand = onCommand[no];
    }

    public void offButton(int no){
        offCommand[no].execute();
        undoCommand = offCommand[no];
    }

    public void undoButton(){
        undoCommand.execute();
    }

    public void setCommand(int no, ICommand onCommand, ICommand offCommand) {
        this.onCommand[no] = onCommand;
        this.offCommand[no] = offCommand;
    }

}
