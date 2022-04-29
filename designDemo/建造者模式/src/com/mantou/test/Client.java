package com.mantou.test;

public class Client {
    public static void main(String[] args) {
        MyBuilder myBuilder = new MyBuilder();
        Director director = new Director(myBuilder);
        Product product = director.construct();
        product.show();
    }
}

//产品
class Product{
    private String partA ;
    private String partB ;
    private String partC ;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println(this.getPartA() + "," + this.getPartB() + "," + this.getPartC());
    }
}

//抽象建造者
abstract class Builder{
    //创建产品对象
    Product product = new Product();
    public abstract void createPartA();
    public abstract void createPartB();
    public abstract void createPartC();
    //返回产品对象
    public Product getProduct(){
        return product;
    }
}
//具体建造者
class MyBuilder extends Builder{

    @Override
    public void createPartA() {
        product.setPartA("建造PartA");
    }

    @Override
    public void createPartB() {
        product.setPartB("建造PartB");
    }

    @Override
    public void createPartC() {
        product.setPartC("建造PartC");
    }
}
//指挥者
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct() {
        builder.createPartA();
        builder.createPartB();
        builder.createPartC();
        return builder.getProduct();
    }
}

