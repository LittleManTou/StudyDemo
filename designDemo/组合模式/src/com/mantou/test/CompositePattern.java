package com.mantou.test;

import java.util.ArrayList;

/**
 * 以透明的方式实现
 */
public class CompositePattern {
    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();
        Component l1 = new Leaf("叶子1");
        Component l2 = new Leaf("叶子2");
        Component l3 = new Leaf("叶子3");
        c0.add(l1);
        c0.add(c1);
        c1.add(l2);
        c1.add(l3);
        c0.operation();
    }
}
//抽象构件
interface Component {
    public void add(Component component);
    public void remove(Component component);
    public Component getChild(int i);
    public void operation();
}
//树叶构件
class Leaf implements Component {
    private String name ;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void remove(Component component) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "被访问！");
    }
}

//树枝构建
class Composite implements Component {
    ArrayList<Component> list = new ArrayList<>();
    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        for (Component component : list) {
            component.operation();
        }
    }
}