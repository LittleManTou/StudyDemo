package com.mantou.test;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}
//抽象主题
interface  Subject{
    void Request();
}
//真实主题
class RealSubject implements Subject {
    @Override
    public void Request() {
        System.out.println("访问真实主题...");
    }
}
//代理
class Proxy implements  Subject {
    private RealSubject realSubject ;
    @Override
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        BeforeRequest();
        realSubject.Request();
        AfterRequest();
    }
    private void BeforeRequest(){
        System.out.println("访问真实主题前的处理...");
    }
    private void AfterRequest(){
        System.out.println("访问真实主题后的处理...");
    }
}