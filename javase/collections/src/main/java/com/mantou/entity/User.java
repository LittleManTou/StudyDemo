package com.mantou.entity;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class User implements Delayed {

    private Integer id ;
    private String userName ;
    private Long stopTime ;

    public User(Integer id, String userName, Long stopTime) {
        this.id = id;
        this.userName = userName;
        this.stopTime = stopTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getStopTime() {
        return stopTime;
    }

    public void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", stopTime=" + stopTime +
                '}';
    }
    //取出元素时调用
    @Override
    public long getDelay(TimeUnit unit) {
        return this.getStopTime() - System.currentTimeMillis();
    }
    //放入元素时进行排序比较
    @Override
    public int compareTo(Delayed o) {
        User u = (User) o ;
        //队列中的数据到期时间比较
        return this.getStopTime().compareTo(u.getStopTime());
    }
}
