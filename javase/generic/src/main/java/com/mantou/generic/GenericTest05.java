package com.mantou.generic;

import java.util.ArrayList;

/**
 * @author mantou
 * @date 2021/11/2 9:49
 * @desc 通配符
 * G<?>是G<A>和G<B>的父类
 * 遍历泛型类型数据的时候用Object即可
 */
public class GenericTest05 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Object> list3 = new ArrayList<>();
        ArrayList<?> list = new ArrayList<>();
        list = list1;
        list = list2;
        list= list3;

        TestG testG = new TestG();
        testG.a(new ArrayList<String>());
        testG.a(new ArrayList<Integer>());
    }
}

class TestG{
    public void a(ArrayList<?> arrayList){
        //1.遍历使用Object
        for (Object o : arrayList) {

        }
        //2.不能随意的添加数据，但是可以是null
        //arrayList.add("123");   报错
        arrayList.add(null);
        //3.获取数据用Object接收
        Object obj = arrayList.get(0);
    }

}
