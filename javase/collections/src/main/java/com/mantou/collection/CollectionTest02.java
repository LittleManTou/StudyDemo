package com.mantou.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author mantou
 * @date 2021/11/1 14:15
 * @return
 * @desc 遍历collection集合
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("zhangsan");
        collection.add("lisi");
        collection.add("wangwu");
        collection.add("zhaoliu");
        //方式1：普通for循环   , 没有获取元素的方法，所以不能使用普通for循环

        //方式2：增强for循环
        for (Object c: collection) {
            System.out.println(c);
        }
        //方式3：迭代器
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
