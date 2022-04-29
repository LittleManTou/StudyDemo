package com.mantou.bean;

public class Sub extends Calculate{
    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}
