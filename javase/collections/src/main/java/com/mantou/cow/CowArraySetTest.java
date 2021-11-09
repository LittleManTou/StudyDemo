package com.mantou.cow;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mantou
 * @date 2021/11/8 14:17
 * @desc 读写分离容器
 */
public class CowArraySetTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);   //不会添加重复元素
        System.out.println(set);
    }
}
