package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;
/**
 * @author mantou
 * @date 2021/11/9 17:29
 * @desc Interrupted
 */
public class InterruptedTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (; ; ) {
                if (Thread.interrupted()) {
                    System.out.println("设置了打断标志位");
                    System.out.println(Thread.interrupted());   //false
                    break;
                }
            }
        });
        t1.start();
        SleepHelper.sleepSeconds(2);
        t1.interrupt();
    }
}
