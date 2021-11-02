package com.mantou.generic;
/**
 * @author mantou
 * @date 2021/11/2 9:12
 * @desc 泛型类的继承
 */
public class GenericTest02<E> {
    public void a(E n){
        System.out.println("n ==== " + n);
    }
}
//父类指定泛型
class Demo01 extends  GenericTest02<String>{

}
//父类不指定泛型,子类必须是泛型类，这个类型可以在子类创建的时候确定
class Demo02<E> extends GenericTest02<E> {

}

class TestEx{
    public static void main(String[] args) {
        //父类指定泛型，子类可以直接使用
        Demo01 demo01 = new Demo01();
        demo01.a("mantou");

    }
}
