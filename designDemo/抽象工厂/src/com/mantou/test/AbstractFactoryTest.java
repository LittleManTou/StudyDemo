package com.mantou.test;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        Factory factory = (Factory)MyReadXml.getObjet();
        Product1 product1 = factory.createProduct1();
        Product2 product2 = factory.createProduct2();
        product1.show();
        product2.show();
    }
}
//抽象产品
interface Product{
    public void show();
}
//具体产品1
class Product1 implements Product{
    @Override
    public void show() {
        System.out.println("生产空调！");
    }
}
//具体产品2
class Product2 implements Product{
    @Override
    public void show() {
        System.out.println("生产电视！");
    }
}

//抽象工厂
interface Factory{
    public Product1 createProduct1();
    public Product2 createProduct2();
}
//具体工厂1
class Factory1 implements Factory {
    @Override
    public Product1 createProduct1() {
        System.out.println("格力生产了空调！");
        return new Product1();
    }

    @Override
    public Product2 createProduct2() {
        System.out.println("格力生产了电视！");
        return new Product2();
    }
}
//具体工厂2
class Factory2 implements Factory {
    @Override
    public Product1 createProduct1() {
        System.out.println("海尔生产了空调！");
        return new Product1();
    }

    @Override
    public Product2 createProduct2() {
        System.out.println("海尔生产了电视！");
        return new Product2();
    }
}

