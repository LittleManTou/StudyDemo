package com.mantou.cow;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mantou
 * @date 2021/11/8 14:06
 * @desc 读写分离容器
 * 适合高并发读的时候使用
 */
public class CowArrayListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("mantou");
        list.add("zhangsan");
        list.add("lisi");
        System.out.println(list);
        list.addIfAbsent("wangwu");
        //如果数组中存在该元素，则不添加
        list.addIfAbsent("lisi");
        System.out.println(list);
    }
}
