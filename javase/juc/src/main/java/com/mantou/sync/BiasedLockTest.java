package com.mantou.sync;

import com.mantou.utils.SleepHelper;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author mantou
 * @date 2021/11/11 14:36
 * @desc 偏向锁启动时延
 */
public class BiasedLockTest {
    public static void main(String[] args) {
        SleepHelper.sleepSeconds(5);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
