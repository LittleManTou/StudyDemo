package com.mantou.visibility;

import com.mantou.utils.SleepHelper;

/**
 * @author mantou
 * @date 2021/11/10 10:09
 * @desc volatile保持可见性
 */
public class VolatileTest {
    private static volatile  Boolean running = true ;
    private static void get(){
        System.out.println( "start！");
        while (running) {
            //System.out.println(running);

        }
        System.out.println("end！");
    }
    public static void main(String[] args) {

        new Thread(VolatileTest::get,"t1").start();

        SleepHelper.sleepSeconds(1);

        running = false;
    }
}
