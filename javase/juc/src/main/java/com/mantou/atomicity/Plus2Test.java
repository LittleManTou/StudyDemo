package com.mantou.atomicity;

import java.util.concurrent.CountDownLatch;

/**
 * @author mantou
 * @date 2021/11/10 17:06
 * @desc 原子性测试
 */
public class Plus2Test {
    private static long n = 0L ;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100] ;
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (Plus2Test.class) {    //上锁保证原子操作
                        n++;    // 不是原子操作，会导致线程争抢
                    }

                }
                latch.countDown();
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();

        System.out.println(n);   //974571

    }
}
