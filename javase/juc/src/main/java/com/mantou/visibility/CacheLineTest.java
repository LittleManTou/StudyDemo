package com.mantou.visibility;

import java.util.concurrent.CountDownLatch;

/**
 * @author mantou
 * @date 2021/11/10 13:38
 * @desc 缓存一致性
 */
public class CacheLineTest {

    public static long COUNT = 1000000000L;

     private static class T {
         private long p1,p2,p3,p4,p5,p6,p7 ;
         public long x = 0L ;
         private long p9,p10,p11,p12,p13,p14,p15 ;
     }

     public static T[] arr = new T[2] ;

     static  {
         arr[0] = new T() ;
         arr[1] = new T() ;
     }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2) ;

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

        final long start = System.nanoTime() ;
        t1.start();
        t2.start();
        latch.await();
        final long end = System.nanoTime() ;
        System.out.println((end - start) / 1000000);


    }
}
