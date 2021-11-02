package com.mantou.generic;
/**
 * @author mantou
 * @date 2021/11/2 9:33
 * @desc 泛型方法
 * 泛型方法的要求：方法的泛型参数的类型与类的泛型参数类型无关
 * 泛型方法的参数类型是调用方法的时候确定的
 * 泛型方法可以是静态的
 */
public class GenericTest04<E> {
    //不是泛型方法
    public void aVoid(E a){

    }
    //泛型方法
    public <T> void  bVoid(T t){

    }
}
