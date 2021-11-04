package com.mantou.entity;
/**
 * @author mantou
 * @date 2021/11/2 16:42
 * @desc 节点类
 */
public class Node<E> {
    /**
     * 前一个元素
     */
    private Node<E> pre ;
    /**
     * 存储的数据
     */
    private E data ;
    /**
     * 后一个元素
     */
    private Node<E> next ;

    public Node() {
    }

    public Node<E> getPre() {
        return pre;
    }

    public void setPre(Node<E> pre) {
        this.pre = pre;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "pre=" + pre +
                ", data=" + data +
                ", next=" + next +
                '}';
    }
}
