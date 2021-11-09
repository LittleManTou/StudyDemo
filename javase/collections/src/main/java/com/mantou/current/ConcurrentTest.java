package com.mantou.current;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mantou
 * @date 2021/11/8 9:59
 * @desc 并发容器
 */
public class ConcurrentTest {
    public static void main(String[] args) {
        ArrayList<String> oldList = new ArrayList<>();
        //转为线程安全的集合
        List<String> newList = Collections.synchronizedList(oldList);

        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    newList.add("aa");
                }
            });
        }

        //关闭线程池
        pool.shutdown();

        while (true){
            if (pool.isTerminated()){
                int size = newList.size();
                System.out.println(size);
                if (size == 10000) {
                    System.out.println("线程安全");
                }else{
                    System.out.println("线程不安全");
                }
                break;
            }
        }

    }
}
