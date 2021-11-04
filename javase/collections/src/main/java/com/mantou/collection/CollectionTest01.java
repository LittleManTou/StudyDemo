package com.mantou.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author mantou
 * @date 2021/11/1 13:52
 * @return
 * @desc collection接口
 *       集合的特点，集合只能存储引用数据类型数据，基本数据类型会自动装箱存储。
 */
public class CollectionTest01 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        Collection collection1 = new ArrayList();
        //1.增加功能   add(E e)   addAll(Collection<? extends E> c)
        collection.add(15);
        collection.add(12);
        collection.add(6);
        collection.add("mantou");
        System.out.println(collection.toString());    //[15, 12, 6, mantou]

        collection1.add(6);
        collection1.add("mantou");
        collection.addAll(collection1);

        System.out.println(collection.toString());  // [15, 12, 6, mantou, 6, mantou]

        //2.判断功能   contains(Object o)  equals(Object o)  isEmpty()
        System.out.println(collection.contains("mantou"));   //true
        System.out.println(collection.containsAll(collection1));  //true
        System.out.println(collection.equals(collection1)); //false
        System.out.println(collection.isEmpty());  //false
        //3.查看功能   size()
        System.out.println(collection.size());    //   6
        //4.转换功能   toArray()
        System.out.println(collection.toArray()[0]);  //  15
        //5.删除功能   clear()   remove(Object o)
        System.out.println(collection.remove("mantou"));  //true
        collection.clear();
        System.out.println(collection.size()); //   0
    }
}
