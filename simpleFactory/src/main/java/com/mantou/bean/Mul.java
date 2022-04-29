package com.mantou.bean;

public class Mul extends Calculate{
    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}
