package com.mantou.list;

import com.mantou.entity.Node;

/**
 * @author mantou
 * @date 2021/11/2 16:46
 * @desc 仿写LinkedList源码
 */
public class MyLinkedList<E> {
    /**
     * 首节点
     */
    private Node<E> first ;

    /**
     * 尾节点
     */
    private Node<E> last ;

    /**
     * 计数器
     */
    private Integer count = 0 ;

    /**
     * 空参构造器
     */
    public MyLinkedList() {
    }

    /**
     * add方法
     */
    public void add(E data){
        if (first == null) {     //表示这是第一个元素
            Node<E> node = new Node();
            node.setPre(null);
            node.setData(data);
            node.setNext(null);
            //当前链中第一个节点变为node
            first = node ;
            //当前最后一个节点变为node
            last = node ;
        }else{     //表示不是第一个节点了
            Node<E> node = new Node();
            node.setPre(last);
            node.setData(data);
            node.setNext(null);
            //当前链中的最后一个节点的下一个元素指向node
            last.setNext(node);
            //将最后一个节点变为n
            last = node ;
        }
        //链中元素数量增加
        count++ ;
    }

    /**
     * 获取集合中的元素数量
     */
    public Integer getSize(){
        return count ;
    }
    /**
     * 通过index获取集合中的元素
     */
    public E get(Integer index){
        //获取链表头元素
        Node<E> node = first ;
        for (int i = 0; i < index; i++) {
            node = node.getNext() ;
        }
        return (E) node.getData();
    }
}
class TestMyList{
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("mantou");
        list.add("zhangsan");
        list.add("wangwu");
        for (int i = 0; i < list.getSize() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.getSize());
    }
}
