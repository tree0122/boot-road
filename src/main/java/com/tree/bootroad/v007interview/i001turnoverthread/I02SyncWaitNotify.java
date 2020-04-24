package com.tree.bootroad.v007interview.i001turnoverthread;

public class I02SyncWaitNotify {
    Object o = new Object();

    public void turn() {
        new Thread(() -> {
            int i = 0;
            synchronized (o){
                while (i++ < 10){
                    System.out.print("a");
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
            System.out.println();
        }, "t1").start();

        new Thread(() -> {
            int i = 0;
            synchronized (o){
                while (i++ < 10){
                    System.out.print("b");
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
            System.out.println();
        }, "t2").start();
    }

}
