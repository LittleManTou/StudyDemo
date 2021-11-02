package com.mantou.generic;
/**
 * @author mantou
 * @date 2021/11/2 8:45
 * @desc 泛型类
 * GenericTest01  就是一个普通类
 * GenericTest01<T> 就是一个泛型类
 * <>里面是一个引用数据类型的占位符，但具体是什么类型，不确定
 */
public class GenericTest01<E> {
    private String name ;
    private E age ;
    public void a(E n){

    }
    public void b(E[] m){

    }
}
class Test{
    public static void main(String[] args) {
        //1.不指定泛型，默认为Object类型
        GenericTest01 genericTest01 = new GenericTest01();
        genericTest01.a(1);
        genericTest01.a("b");
        genericTest01.a(2.5);
        genericTest01.b(new String[]{"zhangsan","lisi","wangwu"});
        //2.指定泛型
        GenericTest01<String> genericTest02 = new GenericTest01<>();
        genericTest02.a("b");
        genericTest02.b(new String[]{"zhangsan","lisi","wangwu"});

    }
}
