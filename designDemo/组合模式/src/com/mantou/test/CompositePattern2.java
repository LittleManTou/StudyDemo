package com.mantou.test;

import java.util.ArrayList;

/**
 * 安全方式实现组合
 */
public class CompositePattern2 {
    public static void main(String[] args) {
        Composite2 c0 = new Composite2();
        Composite2 c1 = new Composite2();
        Component2 l1 = new Leaf2("1");
        Component2 l2 = new Leaf2("2");
        Component2 l3 = new Leaf2("3");
        c0.add(l1);
        c1.add(l2);
        c1.add(l3);
        c0.add(c1);
        c0.opration();

    }
}

//抽象构件
interface Component2 {
    public void opration();
}
//树叶构件
class Leaf2 implements Component2 {
    private String name ;

    public Leaf2(String name) {
        this.name = name ;
    }

    @Override
    public void opration() {
        System.out.println("树叶" + name + "被访问!");
    }
}
//树枝构件
class Composite2 implements Component2 {
    ArrayList<Component2> list = new ArrayList<>();
    public void add(Component2 component2) {
        list.add(component2);
    }
    public void remove(Component2 component2) {
        list.remove(component2);
    }
    public Component2 getChild(int i){
        return list.get(i);
    }
    @Override
    public void opration() {
        for (Component2 component2 : list) {
            component2.opration();
        }
    }
}
