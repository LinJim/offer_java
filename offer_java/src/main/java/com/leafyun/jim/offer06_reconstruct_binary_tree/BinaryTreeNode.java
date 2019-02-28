package com.leafyun.jim.offer06_reconstruct_binary_tree;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 二叉树节点
 * @date: 2018-10-26
 * @time: 1:34
 */
public class BinaryTreeNode {
    // 数据项
    public int data;
    // 左子节点
    public BinaryTreeNode leftChild;
    // 右子节点
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}