package com.mantou.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author mantou
 * @date 2021/11/8 9:20
 * @desc Collections 工具类
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"cc","dd","aa","ee","bb");
        System.out.println(list);
        //二分查找之前要先排序
        Collections.sort(list);
        System.out.println(list);
        Collections.binarySearch(list,"cc");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2,"ww","zz","mm");
        Collections.copy(list,list2);

        System.out.println(list);

    }
}
