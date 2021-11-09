package com.mantou.block;

import com.mantou.entity.User;

import java.text.SimpleDateFormat;
import java.util.concurrent.DelayQueue;

/**
 * @author mantou
 * @date 2021/11/9 10:33
 * @desc  DelayQueue
 * 特点：是一个无界的阻塞队列，用于放置实现了Delayed接口的对象，其中对象只能在其到期时才能被取走。
 *
 * 		不能放null
 */
public class DelayQueueTest {
    DelayQueue<User> queue = new DelayQueue<>() ;

    //登录游戏
    public void login(User user){
        queue.put(user);
        System.out.println("用户：" + user.getUserName()  + "，预计到期时间为:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getStopTime()));
    }
    //时间到，退出游戏
    public void logout(){
        //打印队列中剩余的人
        System.out.println(queue);
        try {
            User user = queue.take();
            System.out.println("用户：" + user.getUserName() + ",已经下线");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //获取在线人数
    public Integer onlineSize(){
        return queue.size();
    }


    public static void main(String[] args) {
        //创建测试类对象
        DelayQueueTest test = new DelayQueueTest() ;

        test.login(new User(1,"馒头",System.currentTimeMillis() + 5000));
        test.login(new User(2,"肉饼",System.currentTimeMillis() + 10000));
        test.login(new User(3,"烧饼",System.currentTimeMillis() + 3000));
        //一直监控，有到期的就下线
        while (true) {
            test.logout();
            if (test.onlineSize() == 0) break;
        }
    }

}
