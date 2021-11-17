package com.mantou.stop;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/9 18:32
 * @desc VolatileTest
 */
public class VolatileTest {
    private static volatile Boolean running = true ;
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            long i = 0l ;
            while (running){
                i++ ;   //使用 wait recv occept 会阻塞
            }
            System.out.println(i); //3407256287  3537106250
        });
        t.start();
        SleepHelper.sleepSeconds(3);
        running = false ;

    }
}
