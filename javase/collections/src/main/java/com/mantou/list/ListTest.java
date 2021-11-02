package com.mantou.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mantou
 * @date 2021/11/1 14:34
 * @return
 * @desc List接口常用方法
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add("mantou");
        //1.增加功能  add(int index, E element)
        list.add(2,"lisi");
        //2.查看功能  get(int index)
        System.out.println(list.get(2));   //lisi
        //3.修改功能
        System.out.println(list.set(2, "wangwu"));  // lisi
        //4.删除功能  remove(int index)
        System.out.println(list.remove(2));  //wangwu

        //遍历List

        //1.普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //2.增强for循环
        for (Object o : list) {
            System.out.println(o);
        }
        //3.迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
