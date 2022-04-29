package com.mantou.bean;

public class Add extends Calculate{
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}
