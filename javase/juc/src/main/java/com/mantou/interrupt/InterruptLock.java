package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mantou
 * @date 2021/11/9 18:08
 * @desc InterruptLock
 */
public class InterruptLock {
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
           lock.lock();

            lock.unlock();
            System.out.println("t2 over");
        });
        t2.start();
        t2.interrupt();
    }
}
