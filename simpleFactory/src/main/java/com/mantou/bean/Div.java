package com.mantou.bean;

public class Div extends Calculate{
    @Override
    public double getResult() {
        double result = 0;
        try {
            if (getNumberB() == 0) throw new Exception("numberB不能为0!");
            result = getNumberA() / getNumberB();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result ;
    }
}
