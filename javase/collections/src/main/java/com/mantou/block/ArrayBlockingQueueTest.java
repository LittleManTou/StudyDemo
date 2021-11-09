package com.mantou.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author mantou
 * @date 2021/11/8 15:05
 * @desc ArrayBlokingQueue
 *
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        //1.添加元素
        queue.add("mantou");
        queue.offer("zhangsan");
        queue.put("lisi");
        //2.队列满的时候继续添加
        //queue.add("wangwu");   //报错 Queue full
       // System.out.println(queue.offer("wangwu"));   // 返回false
        //queue.put("wangwu");  //真正阻塞的方法，会一直等待队列有空
        System.out.println(queue);

        //3.获取元素
        System.out.println(queue.peek());   //取出队列第一个元素，但不删除
        System.out.println(queue);

        System.out.println(queue.poll());    //取出队列第一个元素，并删除
        System.out.println(queue);

        System.out.println(queue.take());    //取出第一个元素，并删除
        System.out.println(queue);

        queue.clear();   //清空队列

        System.out.println(queue.peek());     // null
        System.out.println(queue.poll());     // null
        System.out.println(queue.poll(2, TimeUnit.SECONDS));   //阻塞两秒，然后取出
        System.out.println(queue.take());     //真正阻塞的方法
    }
}
