package com.mantou.map;

import java.util.HashMap;

/**
 * @author mantou
 * @date 2021/11/5 14:37
 * @desc HashMap JDK1.8 实现原理
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(10);
        //map.put("通话", 10);
        //集合中添加元素
        System.out.println(map.put("通话", 10));
        System.out.println(map.put("随便", 20));
        System.out.println(map.put("通话", 30));
        System.out.println(map.put("重地", 40));

        System.out.println("集合元素个数:"+ map.size());
        System.out.println("集合：" + map);

        String str1 = "mantou";
        String str2= "mantou";
        System.out.println(str1 == str2);
    }
}
