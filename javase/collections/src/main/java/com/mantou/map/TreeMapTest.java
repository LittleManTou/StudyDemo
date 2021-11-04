package com.mantou.map;

import com.mantou.entity.Car;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/**
 * @author mantou
 * @date 2021/11/4 19:26
 * @desc TreeMap集合
 *  TreeMap集合 key必须实现比较器接口
 *  key唯一且key按照比较器规则排序
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Car,Integer> map = new TreeMap<>(new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                if (c1.getName().compareTo(c2.getName()) == 0)
                    return c1.getPrice() - c2.getPrice() ;
                return c1.getName().compareTo(c2.getName());
            }
        });
        map.put(new Car("C布加迪",20000000),1);
        map.put(new Car("A奥迪",100000),2);
        map.put(new Car("A奥迪",200000),3);
        map.put(new Car("B奔驰",300000),4);
        map.put(new Car("C宝马",200000),5);
        map.put(new Car("A奥迪",100000),6);
        System.out.println(map);
    }
}
