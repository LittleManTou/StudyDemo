package com.mantou.create;

import java.util.concurrent.*;

/**
 * @author mantou
 * @date 2021/11/9 15:21
 * @desc 创建线程的五种方式
 */
class MyThread extends Thread {
    public void run(){
        System.out.println("hello MyThread!");
    }
}
class MyRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("hello MyRunable");
    }
}

class MyCall implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("hello MyCall");
        return "success";
    }
}
public class CreateTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.自定义类继承Thread类
        new MyThread().start();
        //2.自定义类实现Runable接口
        new Thread(new MyRunable()).start();
        //3.Lambda表达式
        new Thread(() -> {
            System.out.println("hello Thread");
        }).start();
        //4.使用线程池
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("hello service");
        });

        //5.Callable接口，接收带返回值的线程方法
        Future<String> future = service.submit(new MyCall());
        String data = future.get();
        System.out.println(data);
        service.shutdown();
        //6.不使用线程池运行Callable
        FutureTask<String> task = new FutureTask<>(new MyCall());
        new Thread(task).start();
        System.out.println(task.get());



    }
}
