package com.mantou.create;

import com.mantou.utils.SleepHelper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mantou
 * @date 2021/11/9 16:42
 * @desc  线程状态
 */
public class ThreadStateTest {
    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------------------");
        Thread t1 = new Thread(() -> {
            System.out.println("2:" + Thread.currentThread().getState());
            for (int i = 0; i < 3; i++) {
                SleepHelper.sleepSeconds(1);
                System.out.print(i + " ");
            }
            System.out.println();
        });
        System.out.println("1:" + t1.getState());
        t1.start();
        t1.join();
        System.out.println("3:" + t1.getState());
        System.out.println("-----------------------------------------");

        Thread t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("t2 go on!");
            SleepHelper.sleepSeconds(5);
        });
        t2.start();;
        SleepHelper.sleepSeconds(1);
        System.out.println("4:" + t2.getState());

        LockSupport.unpark(t2);
        SleepHelper.sleepSeconds(1);
        System.out.println("5:"+ t2.getState());
        System.out.println("-----------------------------------------");
        final Object o = new Object();
        Thread t3 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t3 得到了锁 o");
            }
        });
        new Thread(() -> {
            synchronized (o) {
                SleepHelper.sleepSeconds(5);
            }
        }).start();

        SleepHelper.sleepSeconds(1);
        t3.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("6:" + t3.getState());
        System.out.println("-----------------------------------------");
        final Lock lock = new ReentrantLock() ;
        Thread t4 = new Thread(() -> {
            lock.lock();
                System.out.println("t4 得到了锁 o");
            lock.unlock();
        });
        new Thread(() -> {
            lock.lock();
                SleepHelper.sleepSeconds(5);
            lock.unlock();
        }).start();

        SleepHelper.sleepSeconds(1);
        t4.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("7:" + t4.getState());
        System.out.println("-----------------------------------------");
        Thread t5 = new Thread(() -> {
            LockSupport.park();
        });
        t5.start();
        SleepHelper.sleepSeconds(1);
        System.out.println("8:" + t5.getState());
        LockSupport.unpark(t5);
    }
}
