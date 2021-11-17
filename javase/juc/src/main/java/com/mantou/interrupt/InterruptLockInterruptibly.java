package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mantou
 * @date 2021/11/9 18:13
 * @desc InterruptLockInterruptibly
 */
public class InterruptLockInterruptibly {
    private static Lock lock = new ReentrantLock() ;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            SleepHelper.sleepSeconds(10);
            lock.unlock();
        });
        t1.start();
        SleepHelper.sleepSeconds(1);
        Thread t2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();     //这个方法可以干扰到抢锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("t2 over");
        });
        t2.start();
        t2.interrupt();
    }
}
