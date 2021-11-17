package com.mantou.interrupt;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 17:36
 * @desc InterruptSleep
 */
public class InterruptSleepTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("设置了打断标志位");
                System.out.println(Thread.currentThread().isInterrupted());  //false jdk抓住异常会自动重置标志位
            }
        });
        t.start();
        SleepHelper.sleepSeconds(5);
        t.interrupt();
    }
}
