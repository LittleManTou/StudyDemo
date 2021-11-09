package com.mantou.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mantou
 * @date 2021/11/9 11:04
 * @desc DequeTest
 *
 * Queue一端放一端取得方法 Deque是支持的
 *
 * 在此基础上又宽展了一些头尾操作
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offer("A");
        deque.offer("B");
        deque.offer("C");
        deque.offerFirst("D");
        deque.offerLast("E");
        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
