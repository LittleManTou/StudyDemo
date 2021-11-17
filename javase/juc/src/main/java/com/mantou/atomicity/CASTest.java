package com.mantou.atomicity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mantou
 * @date 2021/11/10 18:05
 * @desc CAS
 */
public class CASTest {
    AtomicInteger count = new AtomicInteger();
    void m() {
        for (int i = 0; i < 10000 ; i++) {
            count.incrementAndGet();    //代替count++
        }
    }
    public static void main(String[] args) {
        CASTest casTest = new CASTest() ;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
           threads.add(new Thread(casTest::m,"t" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(casTest.count);

    }
}
