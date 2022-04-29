package com.mantou.test;

/**
 * 桥接模式
 */
public class BridgeTest {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.Operation();
    }
}
//实现化角色
interface  Implementor{
    public void OperationImpl();
}
//具体实现化角色
class ConcreteImplementorA implements Implementor{
    @Override
    public void OperationImpl() {
        System.out.println("具体实现化角色被访问！");
    }
}
//抽象化角色
abstract class Abstraction{
    protected Implementor impl ;
    protected Abstraction(Implementor impl) {
        this.impl = impl ;
    }
    public abstract  void Operation();
}
//扩展抽象化角色
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor impl) {
        super(impl);
    }
    @Override
    public void Operation() {
        System.out.println("扩展抽象化角色被访问！");
        impl.OperationImpl();
    }
}
