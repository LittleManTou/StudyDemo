package com.mantou.list;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author mantou
 * @date 2021/11/2 14:20
 * @desc LinkedList 常用API
 * 注意：尽量使用JDK1.6之后更新的增删改查接口，因为增强了健壮性，例如空链表使用remove方法会报错，但是使用poll不会
 * 总结：增加使用offer 查看使用peek 删除使用poll
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //1.增加 add(E e) add(int index, E element) addFirst(E e) addLast(E e)  JDK1.6之前的接口
        // offer(E e)  offerFirst(E e)  offerLast(E e)  JDK1.6 的接口
        list.add("zhangsan");   //添加到列表的末尾
        list.offer("mantou");   //添加到列表的末尾
        list.offerFirst("lisi");    //添加到列表前面
        list.offerLast("wangwu");   //添加到列表末尾
        System.out.println(list.toString());   // [lisi, zhangsan, mantou, wangwu]
        //2.修改  set(int index, E element)
        list.set(1,"zhaoliu");
        //3.查看  get(int index) getFirst() getLast() size()
        System.out.println(list.get(1));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        //peek() peekFirst() peekLast()
        System.out.println(list.peek());  //查找链表第一个元素
        System.out.println(list.peekFirst()); //查找链表第一个元素
        System.out.println(list.peekLast()); //查找链表最后一个元素
        //4.删除 clear()  remove(int index) removeFirst() removeLast()
        //poll() pollFirst() pollLast()
        //list.clear();   //清空链表
        //System.out.println(list.poll());  //删除链表第一个元素 ，空链表不会报错 ，返回null
        //System.out.println(list.remove()); //删除链表第一个元素, 空链表报错
        //5.判断  contains(Object o)
        System.out.println("_________________________________________");
        //遍历
        //方式1：普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("_________________________________________");
        //方式2：增强for
        for(String s : list) {
            System.out.println(s);
        }
        System.out.println("_________________________________________");
        //方式3：迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("_________________________________________");
        //方式4：for循环迭代  ，这种方式更好，因为节省内存
        for (Iterator<String> it2 = list.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }
    }
}
