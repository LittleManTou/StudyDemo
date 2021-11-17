package com.mantou.stop;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 18:19
 * @desc stop
 */
public class StopTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                SleepHelper.sleepSeconds(1);
                System.out.println("go on");
            }
        });
        t.start();
        SleepHelper.sleepSeconds(5);
        t.stop();
    }
}
