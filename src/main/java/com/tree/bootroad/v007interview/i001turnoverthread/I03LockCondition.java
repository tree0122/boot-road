package com.tree.bootroad.v007interview.i001turnoverthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class I03LockCondition {
    Lock lock = new ReentrantLock();
    Condition cond1 = lock.newCondition();
    Condition cond2 = lock.newCondition();


    public void turn() {
        new Thread(() -> {
            try {
               lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("a");
                    cond2.signal();
                    cond1.await();
                }
                cond2.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
            System.out.println();
        }, "t1").start();


        new Thread(() -> {
            try {
               lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("b");
                    cond1.signal();
                    cond2.await();
                }
                cond1.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
            System.out.println();
        }, "t2").start();

    }

}
