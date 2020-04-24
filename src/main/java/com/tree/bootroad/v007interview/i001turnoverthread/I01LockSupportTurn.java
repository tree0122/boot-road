package com.tree.bootroad.v007interview.i001turnoverthread;

import java.util.concurrent.locks.LockSupport;

public class I01LockSupportTurn {

    Thread t1, t2;

    public void turn() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.print("a");
                LockSupport.unpark(t2);
                LockSupport.park();
            }
            LockSupport.unpark(t2);
            System.out.println();
        }, "t1");

        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print("b");
                LockSupport.unpark(t1);
            }
            LockSupport.unpark(t1);
            System.out.println();
        }, "t2");

        t1.start();
        t2.start();
    }


}
