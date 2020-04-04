package com.tree.bootroad.v004designpattern.atguigu.design.d14command.sample;

import com.tree.bootroad.v004designpattern.atguigu.design.d14command.sample.command.*;

public class Stage {

    public static void main(String[] args) {
        LightReceiver lightReceiver = new LightReceiver();

        ICommand lightOnCommand = new LightOnCommand(lightReceiver);
        ICommand lightOffCommand = new LightOffCommand(lightReceiver);

        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("====开灯===");
        remoteController.onButton(0);
        System.out.println("====关灯===");
        remoteController.offButton(0);
        System.out.println("====撤销===");
        remoteController.undoButton();
    }

}
