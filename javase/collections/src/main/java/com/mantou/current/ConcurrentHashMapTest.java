package com.mantou.current;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mantou
 * @date 2021/11/8 11:03
 * @desc 并发容器测试
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
        //Hashtable<String, Integer> map = new Hashtable<>();
        //HashMap<String,Integer> map = new HashMap<>();
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Long start = System.currentTimeMillis();
                    for (int j = 0; j < 1000000; j++) {
                        map.put("mantou"+ j,j);
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("一共需要的时间：" +(end -start));
                }
            }).start();
        }
    }
}
