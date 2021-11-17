package com.mantou.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author mantou
 * @date 2021/11/11 9:49
 * @desc JOL 对象内存布局分析工具
 */
public class HelloJol {
    public static void main(String[] args) {
        Object o = new Object() ;
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
