package com.leafyun.jim.offer07_binary_tree_next_node;

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
    // 父节点
    public BinaryTreeNode parent;


    public BinaryTreeNode(int data) {
        this.data = data;
    }
}