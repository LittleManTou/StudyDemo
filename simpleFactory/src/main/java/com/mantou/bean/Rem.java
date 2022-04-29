package com.mantou.bean;

public class Rem extends Calculate{
    @Override
    public double getResult() {
        return getNumberA() % getNumberB();
    }
}
