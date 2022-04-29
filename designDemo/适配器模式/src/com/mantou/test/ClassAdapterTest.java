package com.mantou.test;

/**
 * 类适配器模式
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        classAdapter.request();
    }
}
//目标接口
interface Target{
    public void request();
}
//适配者类
class Adaptee{
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用！");
    }
}
//适配器类
class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}
