package com.mantou.main;

import com.mantou.bean.Calculate;
import com.mantou.factory.CalculateFactory;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operate ;
        Double numberA ;
        Double numberB ;
        double result = 0;
        System.out.println("请输入第一个数:");
        numberA = scanner.nextDouble();
        System.out.println("请输入第二个数:");
        numberB = scanner.nextDouble();
        System.out.println("输入要进行的操作:");
        operate = scanner.next();
        Calculate cal = CalculateFactory.createCaculate(operate) ;
        cal.setNumberA(numberA);
        cal.setNumberB(numberB);
        result = cal.getResult();
        System.out.println(numberA + operate + numberB + "的结果为:" + result);
    }
}
