package com.leafyun.jim.offer05_prin_link_from_end;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 单链表，相当于火车，定义里面只定义了头结点，就是因为可以通过指针域找到火车的车厢，即其他节点
 * @date: 2018-10-16
 * @time: 14:43
 */
public class LinkedList {
    /**
     * 链表头节点
     */
    public Node first;

    /**
     * 不初始化也可以，因为编译器默认会给没初始化的属性赋值
     */
    public LinkedList() {
        first = null;
    }

    /**
     * 在头节点后面插入新节点 【新节点】--->【头结点】
     *
     * @param value 新节点的值
     */
    public void insertFirst(long value) {
        // 构建新节点
        Node temp = new Node(value);
        // 插入逻辑,next 这个属性是 protected 类型，只能子类或者同包下可以引用
        temp.next = first;
        first = temp;
    }

}
