package com.mantou.test;

import java.util.HashMap;

public class FlyweightPattern {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight a1 = flyweightFactory.getFlyweight("a");
        Flyweight a2 = flyweightFactory.getFlyweight("a");
        Flyweight a3 = flyweightFactory.getFlyweight("a");
        Flyweight b1 = flyweightFactory.getFlyweight("b");
        Flyweight b2 = flyweightFactory.getFlyweight("b");
        a1.operation(new UnsharedConcreteFlyweight("第一次调用！"));
        a2.operation(new UnsharedConcreteFlyweight("第二次调用！"));
        a3.operation(new UnsharedConcreteFlyweight("第三次调用！"));
        b1.operation(new UnsharedConcreteFlyweight("第一次调用！"));
        b2.operation(new UnsharedConcreteFlyweight("第二次调用！"));
    }
}
//非享元角色 (不能共享的信息)
class UnsharedConcreteFlyweight {
    private String info;
    public UnsharedConcreteFlyweight(String info) {
       this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
//抽象享元角色
interface Flyweight {
    public void operation(UnsharedConcreteFlyweight state);
}
//具体享元角色
class ConcreteFlyweight implements  Flyweight {
    private String key ;

    public ConcreteFlyweight(String key) {
        this.key = key ;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + state.getInfo());
    }
}
//享元工厂
class FlyweightFactory {
    private HashMap<String,Flyweight> map = new HashMap<>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = (Flyweight)map.get(key);
        if (flyweight != null) {
            System.out.println("享元" + key + "已经存在了！");
        }else{
            flyweight = new ConcreteFlyweight(key);
            map.put(key,flyweight);
        }
        return flyweight;
    }
}
