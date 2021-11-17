package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 17:21
 * @desc 设置打断标志位和查询打断标志位
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; ; ) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("设置了打断标志位");
                    System.out.println(Thread.currentThread().isInterrupted());   //true
                    break;
                }
            }
        });
        t1.start();
        SleepHelper.sleepSeconds(1);
        t1.interrupt();
    }
}
