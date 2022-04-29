package com.mantou.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {
    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();
        IPerson zhaoliu = jdkFuDao.getInstance(new ZhaoLiu());
        zhaoliu.findTeacher();
    }
}
class JdkFuDao implements InvocationHandler {
    private IPerson target;

    public IPerson getInstance(IPerson target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("双方同意，开始辅导");
    }

    private void before() {
        System.out.println("这里是C语言中文网辅导班，已经收集到您的需求，开始挑选老师");
    }
}

//接口
interface IPerson {
    void findTeacher(); //找老师
}

//赵六
class ZhaoLiu implements IPerson {
    @Override
    public void findTeacher() {
        System.out.println("符合赵六的要求");
    }

    public void buyInsure() {

    }
}


