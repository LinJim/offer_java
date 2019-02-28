package com.leafyun.jim.offer06_reconstruct_binary_tree;

import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 给出一棵树的前序和中序遍历的结果，以此还原二叉树
 * @date: 2019-02-12
 * @time: 10:57
 */
public class ReconstructBinaryTree {

    /**
     * 给出一棵树的前序和中序遍历的结果，以此还原二叉树
     * 原理：就是在前序遍历找到第一个数，就是根节点（并构造），就可以在中序遍历划分出左子树和右子树，然后递归构造划分
     *
     * @param pre 前序遍历序列：{1,2,4,7,3,5,6,8}
     * @param in  中序遍历序列：{4,7,2,1,5,3,8,6}
     * @return 二叉树根节点
     */
    public static BinaryTreeNode constructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        return reconstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static BinaryTreeNode reconstructBinaryTree(int[] pre, int preL, int preE, int[] in, int inL, int inE) {
        // 判断，避免数组溢出
        if (preL > preE || preE > pre.length - 1 || inL > inE || inE > in.length - 1) {
            return null;
        }
        // 在先序遍历序列中取出根节点，并构造根节点
        BinaryTreeNode root = new BinaryTreeNode(pre[preL]);
        // 在中序遍历序列中划分左子树右子树，找出根节点位置 index
        int index = 0;
        while (in[index] != pre[preL]) {
            index++;
        }
        // 计算左边多少结点
        int leftTreeSize = index - inL;
        // 构建根节点的左子树和右子树
        root.leftChild = reconstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, index-1);
        root.rightChild = reconstructBinaryTree(pre, preL + leftTreeSize + 1, preE, in, inL + leftTreeSize + 1, inE);
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = constructBinaryTree(pre, in);
        BinaryTree tree = new BinaryTree();
        List<List<String>> lists = tree.printTree(root);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}
