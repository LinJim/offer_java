package com.leafyun.jim.offer06_reconstruct_binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二叉树，其实这里面实现的是二叉查找树，不是普通二叉树
 * @date: 2018-10-26
 * @time: 1:34
 */
public class BinaryTree {
    // 根节点
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * 二叉树打印：给定二叉树，返回按期规定形式返回，即每层位置均保留上下层结构
     * [, , , , , , , 40, , , , , , , ]
     * [, , , 10, , , , , , , , 55, , , ]
     * [, 2, , , , 21, , , , 44, , , , 65, ]
     * [, , , , 20, , 30, , , , , , , , ]
     *
     * @param root 二叉树根节点
     */
    public List<List<String>> printTree(BinaryTreeNode root) {
        // 通过格式确定数据结构，List<List<String>>, List<List<String>> 这个是树，List<String> 是树的每一层
        List<List<String>> list = new ArrayList<>();
        // 确定树有几层，即 List<List<String>> ，里面有多少 list
        int height = getHeight(root);
        // 确定每一个 list 有多长,长度都是 2 的 height 次方 -1，
        // 刚好是一棵树最多元素个数，因为最大层要算上空格，再加上满元素，刚好为一棵树最多元素个数
        int length = (int) Math.pow(2, height) - 1;
        // 先往 list 数组里面填充元素
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 填充一行 "",即 [, , , , , , , , , , , , , , ]
            subList.add("");
        }
        // 为 List<List<String>> 即树，添加层数
        for (int i = 0; i < height; i++) {
            // 填充整个数据，即变成
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            // [, , , , , , , , , , , , , , ]
            list.add(new ArrayList<>(subList));
        }
        // 递归，遍历填充元素到数组中，每次都是数组最左边加最右边 /2 ,当遍历到最后一层或者 root 根节点为 null ，结束
        traverseFill(root, list, 0, height, 0, length - 1);
        return list;
    }

    /**
     * 递归，遍历填充元素到数组中，每次都是数组最左边加最右边/2 ,当遍历到最后一层或者 root 根节点为 null ，结束
     *
     * @param root   根节点
     * @param list   存储数据的数组
     * @param row    开始层数
     * @param height 结束的层数
     */
    public void traverseFill(BinaryTreeNode root, List<List<String>> list, int row, int height, int i, int j) {
        // 如果根节点为 null ，或者遍历到最后一层，结束
        if (root == null || row == height) {
            return;
        }
        // 赋值，把根节点的元素值赋值到 ( 左边加右边 / 2 )的位置
        list.get(row).set((i + j) / 2, String.valueOf(root.data));
        // 填充左子树
        traverseFill(root.leftChild, list, row + 1, height, i, (i + j) / 2 - 1);
        // 填充右子树
        traverseFill(root.rightChild, list, row + 1, height, (i + j) / 2 + 1, j);
    }

    /**
     * 得到树的高度
     *
     * @param root 二叉树根节点
     * @return 数的高度
     */
    public int getHeight(BinaryTreeNode root) {
        // 如果是空树，返回 0
        if (root == null) {
            return 0;
        }
        // 遍历其左子树,得到左子树的高度
        int left = getHeight(root.leftChild);
        // 遍历其右子树,得到右子树的高度
        int right = getHeight(root.rightChild);
        // + 1 是为了当节点（root.leftChild | root.rightChild）为 null ，返回父节点，那么层数就加一，其实就是左子树和右子树的最大高度加上根节点
        return Math.max(left, right) + 1;
    }



}
