package com.mantou.test;

public class FacadePattern {
    //客户角色
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
//外观角色
class Facade {
    private SubSystem01 subSystem01 = new SubSystem01();
    private SubSystem02 subSystem02 = new SubSystem02();
    private SubSystem03 subSystem03 = new SubSystem03();
   public void method(){
       subSystem01.method1();
       subSystem02.method2();
       subSystem03.method3();
   }
}
//子系统角色
class SubSystem01 {
    public void method1() {
        System.out.println("子系统01的method1()被调用！");
    }
}
class SubSystem02 {
    public void method2() {
        System.out.println("子系统02的method2()被调用！");
    }
}
class SubSystem03 {
    public void method3() {
        System.out.println("子系统03的method3()被调用！");
    }
}