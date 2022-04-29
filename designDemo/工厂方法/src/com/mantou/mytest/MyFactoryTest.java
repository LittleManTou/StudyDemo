package com.mantou.mytest;

public class MyFactoryTest {
    public static void main(String[] args) {
        MyFactory myFactory = (MyFactory)MyReadXml.getObjet();
        MyProduct product = myFactory.createProduct();
        product.show();
    }
}

//抽象产品
interface MyProduct{
    public void show();
}
//具体产品1
class Product1 implements  MyProduct{
    @Override
    public void show() {
        System.out.println("展示产品1....");
    }
}
//具体产品2
class Product2 implements MyProduct {
    @Override
    public void show() {
        System.out.println("展示产品2....");
    }
}
//抽象工厂
interface MyFactory{
    public MyProduct createProduct();
}
//具体工厂1
class Factory1 implements MyFactory{
    @Override
    public MyProduct createProduct() {
        System.out.println("工厂1创建产品1");
        return new Product1();
    }
}
//具体工厂2
class Factory2 implements MyFactory{
    @Override
    public MyProduct createProduct() {
        System.out.println("工厂2创建产品2");
        return new Product2();
    }
}