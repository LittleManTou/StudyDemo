package com.mantou.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mantou
 * @date 2021/11/4 16:49
 * @desc Map集合常用方法
 * Map集合的特点：无序，唯一，key唯一  value不唯一
 *
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //添加 put(K key, V value)
        map.put("mantou",111);
        map.put("zhangsan",222);
        map.put("lisi",333);
        map.put("wangwu",444);
        map.put("zhaoliu",555);
        System.out.println(map);
        //查找 entrySet() get(Object key) size() keySet()   values()
        System.out.println(map.get("mantou"));
        System.out.println(map.size());
        //遍历集合的所有key
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
        //遍历集合的所有值
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        //遍历集合的所有键值对
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }



        Map<String,Integer> map2 = new HashMap<>();
        //添加 put(K key, V value)
        map2.put("mantou",111);
        map2.put("zhangsan",222);
        map2.put("lisi",333);
        map2.put("wangwu",444);
        map2.put("zhaoliu",555);

        //判断 containsKey(Object key) containsValue(Object value) equals(Object o) isEmpty()
        System.out.println(map == map2);
        System.out.println(map.equals(map2));
        System.out.println(map.containsKey("mantou"));
        System.out.println(map.containsValue(222));
        //删除  clear() remove(Object key)
        map.clear();
        System.out.println(map);
        map2.remove("mantou");
        System.out.println(map2);
    }
}
