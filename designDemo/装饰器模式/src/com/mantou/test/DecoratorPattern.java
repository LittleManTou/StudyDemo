package com.mantou.test;

public class DecoratorPattern {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(component);
        concreteDecorator.operation();
    }
}
//抽象构建
interface Component {
    public void operation();
}
//具体构建
class ConcreteComponent implements  Component {
    public ConcreteComponent() {
        System.out.println("创建具体构建！");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构件角色的方法operation()");
    }
}
//抽象装饰
class Decorator implements Component {
    protected Component component ;
    public  Decorator(Component component){
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}
//具体装饰
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        addedFunction();
    }
    public void addedFunction() {
        System.out.println("增加的新功能被调用！");
    }
}