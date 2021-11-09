package com.mantou.block;

import com.mantou.entity.Student;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author mantou
 * @date 2021/11/9 10:04
 * @desc PriorityBlockingQueueTest
 * 特点：带优先级的阻塞队列，队列有先后顺序，数据有不同权重
 *
 * 	    无界的队列，没有长度限制，默认初始化长度11但是底层会不断扩容，直到内存溢出。
 *
 * 	    不可以放null元素，不允许放不能比较的对象，自定义对象要实现比较器。
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<>();
        queue.put(new Student("mantou",23));
        queue.put(new Student("roubing",23));
        queue.put(new Student("zhutou",21));
        queue.put(new Student("choudan",25));
        System.out.println(queue);
        System.out.println(queue.take());    // 取数据的时候才有权重
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
