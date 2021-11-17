package com.mantou.visibility;

import com.mantou.utils.SleepHelper;
import jdk.nashorn.internal.ir.WhileNode;

/**
 * @author mantou
 * @date 2021/11/10 10:35
 * @desc volatile  修饰引用数据类型
 */
public class VolatileTest02 {

    private static class A {
        Boolean running = true ;
        void m(){
            System.out.println("start");
            while (running) {

            }
            System.out.println("end");
        }
    }

    private volatile static  A a = new A() ;
    public static void main(String[] args) {
        new Thread(a::m,"t1").start();
        SleepHelper.sleepSeconds(1);
        a.running = false ;
    }
}
