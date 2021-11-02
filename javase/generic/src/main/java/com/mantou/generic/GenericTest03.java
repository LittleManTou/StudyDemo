package com.mantou.generic;

import java.util.ArrayList;

/**
 * @author mantou
 * @date 2021/11/2 9:24
 * @desc 泛型类的细节
 * 可以定义多个参数类型
 * 不同的泛型的引用类型不能相互赋值
 * 泛型如果不指定，泛型就会被擦除
 * 静态方法不能使用类的泛型
 */
public class GenericTest03<A,B,C> {
    public GenericTest03() {
    }
    public void b(){
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        //a1 = a2 ;     是不能赋值的
    }
}
