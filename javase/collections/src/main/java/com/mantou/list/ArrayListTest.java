package com.mantou.list;

import java.util.ArrayList;

/**
 * @author mantou
 * @date 2021/11/1 14:48
 * @return
 * @desc ArrayList集合源码
 * JDK1.7是创建时初始化长度为10，之后每次扩容为之前的1.5倍
 * JDK1.8是调用add方法的时候才会初始化长度为10
 *
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
    }
}
