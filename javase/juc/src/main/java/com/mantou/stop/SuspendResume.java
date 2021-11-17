package com.mantou.stop;

import com.mantou.utils.SleepHelper;
/**
 * @author mantou
 * @date 2021/11/9 18:26
 * @desc SuspendResume
 */
public class SuspendResume {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                SleepHelper.sleepSeconds(1);
                System.out.println("go on");
            }
        });
        t.start();
        SleepHelper.sleepSeconds(2);
        t.suspend();
        SleepHelper.sleepSeconds(5);
        t.resume();
    }
}
