package com.mantou;

/**
 * 原理
 */
public class PrototypeTest {
    public static void main(String[] args) {
        //创建原型类
        Realizetype r1 = new Realizetype();
        //克隆原型类
        try {
            Realizetype r2 = (Realizetype)r1.clone();
            System.out.println(r1 == r2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
//具体原型类，这里的 Cloneable 接口就是抽象原型类。
class Realizetype implements Cloneable {
    public Realizetype() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
