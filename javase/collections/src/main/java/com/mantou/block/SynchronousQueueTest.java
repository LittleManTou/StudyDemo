package com.mantou.block;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author mantou
 * @date 2021/11/9 9:36
 * @desc SynchronousQueueTest
 * 特点：队列容量为0，线程A放入的数据直接被线程B取走,效率高不会产生队列中数据争抢的问题。
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {

        //这是一个空队列，可以理解为一个传送门，不同线程可以有不同的传送门
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        //queue.add("mantou");     报错   Queue full

        //取数据的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        String poll = queue.poll(5, TimeUnit.SECONDS);
                        System.out.println(poll);
                        if (poll == null) {
                            break ;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //放数据的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("mantou");
                    queue.put("roubing");
                    queue.put("zhangsan");
                    queue.put("lisi");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
