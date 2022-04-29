package com.mantou.test;

/**
 * 对象适配器模式
 */
public class ClassAdapterTest2 {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试:");
        Adaptee2 adaptee2 = new Adaptee2();
        Target2 target2 = new ObjectAdater(adaptee2);
        target2.Resquest();
    }
}
//目标接口
interface Target2{
   public void Resquest();
}
//适配者类
class Adaptee2{
    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用！");
    }
}
//对象适配器类
class ObjectAdater  implements Target2{
    private Adaptee2  adaptee2 ;
    public ObjectAdater(Adaptee2 adaptee2) {
        this.adaptee2 = adaptee2;
    }
    @Override
    public void Resquest() {
        adaptee2.specificRequest();
    }
}