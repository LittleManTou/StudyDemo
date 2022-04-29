package com.mantou.factory;

import com.mantou.bean.*;

public class CalculateFactory {
    public static Calculate createCaculate(String operate){
        Calculate cal = null ;
        switch (operate) {
            case "+" :
                cal = new Add();
                break;
            case "-" :
                cal = new Sub();
                break;
            case "*" :
                cal = new Mul();
                break;
            case "/" :
                cal = new Div();
                break;
            case "%" :
                cal = new Rem();
                break;
        }
        return cal ;
    }
}
