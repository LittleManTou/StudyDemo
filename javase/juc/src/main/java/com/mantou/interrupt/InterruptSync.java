package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 17:53
 * @desc InterruptSync
 */
public class InterruptSync {
    private static Object o = new Object() ;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                SleepHelper.sleepSeconds(10);
            }
        });
        t1.start();
        SleepHelper.sleepSeconds(1);
        Thread t2 = new Thread(() -> {
            synchronized (o) {

            }
            System.out.println("t2 over");
        });
        t2.start();
        t2.interrupt();
    }
}
