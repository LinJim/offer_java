package com.leafyun.jim.offer05_prin_link_from_end;

import java.util.Stack;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 从尾到头打印链表
 * @date: 2019-02-12
 * @time: 10:20
 */
public class PrintLinkFromEnd {

    /**
     * 递归实现从尾到头打印链表，递归树先打印最深的结点（最后一个结点），再从最深的结点开始往上
     *
     * @param head 链表 11 20 9 7 5 1 12
     */
    public static void printLinkFromEnd01(Node head) {
        if (head != null) {
            printLinkFromEnd01(head.next);
            System.out.print(head.data + " ");
        }
    }

    /**
     * 栈出栈是入栈实现从尾到头打印链表，其实栈和递归的原理都是一样的，都是后进先出
     *
     * @param head 链表 11 20 9 7 5 1 12
     */
    public static void printLinkFromEnd02(Node head) {
        // 先把链表都入栈，然后再出栈
        Stack<Node> stack = new Stack<Node>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        while (!stack.empty()) {
            Node o = (Node) stack.pop();
            System.out.print(o.data+ " ");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // 测试在头节点后面插入新节点
        list.insertFirst(12);
        list.insertFirst(1);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(20);
        list.insertFirst(11);
        // 链表 11 20 9 7 5 1 12
        printLinkFromEnd02(list.first);

    }
}
