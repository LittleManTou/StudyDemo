package com.mantou.stop;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 18:39
 * @desc InterruptStop
 */
public class InterruptStop {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                //sleep wait 也能正常结束
            }
            System.out.println(" t stop ");
        });
        t.start();
        SleepHelper.sleepSeconds(1);
        t.interrupt();
    }
}
