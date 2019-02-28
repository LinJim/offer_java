package com.leafyun.jim.offer08_use_two_statck_to_queue;

import java.util.Stack;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 用两个栈 s1,s2 实现队列的进队出队功能
 * @date: 2019-02-12
 * @time: 15:12
 */
public class UseTwoStackToQueue {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    /**
     * 队列的进队: 进栈 s1
     *
     * @param node 进队的元素
     */
    public void push(int node) {
        s1.push(node);
    }

    /**
     * 队列的出队: 出栈 s1 ,进栈 s2，出栈 s2,顺序刚好相反了
     */
    public int pop() throws Exception {
        while (!s1.empty()) {
            // 出栈 s1 ,进栈 s2
            Integer node = s1.pop();
            s2.push(node);
        }
        if (s2.empty()) {
            throw new Exception("queue is empty");
        }
        // 出栈 s2
        return s2.pop();
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 8, 9};
        UseTwoStackToQueue queue = new UseTwoStackToQueue();
        for (int i : arr) {
            queue.push(i);
        }
        try {
            int pop = queue.pop();
            int pop2 = queue.pop();
            System.out.println(pop);
            System.out.println(pop2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
