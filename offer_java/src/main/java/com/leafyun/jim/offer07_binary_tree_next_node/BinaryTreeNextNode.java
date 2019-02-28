package com.leafyun.jim.offer07_binary_tree_next_node;

import java.util.List;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 给定一个二叉树，和其中一个结点，找出中序遍历的下一个结点（每个结点都有，父指针，左右孩子指针）
 * @date: 2019-02-12
 * @time: 13:25
 */
public class BinaryTreeNextNode {

    /**
     * 例子：中序遍历序列：{2,10,20,21,30,40,44,55,65}
     * [, , , , , , , 40, , , , , , , ]
     * [, , , 10, , , , , , , , 55, , , ]
     * [, 2, , , , 21, , , , 44, , , , 65, ]
     * [, , , , 20, , 30, , , , , , , , ]
     * <p>
     * 找出中继后续：1. 结点(10)如果有右子树，就是右子树的最左结点(20) 2. 结点(2)如果没有右子树，且为左节点，中继后续为父节点；结点(30)如果没有右子树，但是为右节点，所以中继后续为当他的父节点为上一个父节点的左节点时的上一个父节点
     *
     * @param node
     * @return
     */
    public static BinaryTreeNode getBinaryTreeNextNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        // 结点(10)如果有右子树，就是右子树的最左结点(20)
        if (node.rightChild != null) {
            // 得到右子树
            BinaryTreeNode right = node.rightChild;
            // 找到最左结点
            while (right.leftChild != null) {
                right = right.leftChild;
            }
            return right;
        } else { // 无右子树的情况，合并第二点的两种情况，因为都是求父节点
            // 得到父节点
            BinaryTreeNode parent = node.parent;
            while (parent != null) {
                if (node == parent.leftChild) {
                    return parent;
                }
                node = parent;
                parent = parent.parent;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        /**
         * 例子：中序遍历序列：{2,10,20,21,30,40,44,55,65}
         * [, , , , , , , 40, , , , , , , ]
         * [, , , 10, , , , , , , , 55, , , ]
         * [, 2, , , , 21, , , , 44, , , , 65, ]
         * [, , , , 20, , 30, , , , , , , , ]
         */
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreeNode node0 = new BinaryTreeNode(40);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(55);
        BinaryTreeNode node3 = new BinaryTreeNode(44);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(65);
        BinaryTreeNode node6 = new BinaryTreeNode(21);
        BinaryTreeNode node7 = new BinaryTreeNode(20);
        BinaryTreeNode node8= new BinaryTreeNode(30);
        node0.leftChild=node1;node0.rightChild=node2;node0.parent=null;
        node1.leftChild=node4;node1.rightChild=node6;node1.parent=node0;
        node2.leftChild=node3;node2.rightChild=node5;node2.parent=node0;
        node3.parent=node2;
        node4.parent=node1;
        node6.leftChild=node7;node6.rightChild=node8;node6.parent=node1;
        node7.parent=node6;
        node8.parent=node6;
        List<List<String>> list2 = binaryTree.printTree(node0);
        for (List<String> list1 : list2) {
            System.out.println(list1);
        }
        // 测试空节点，2 ，10 ，30 结点:{2,10,20,21,30,40,44,55,65}
        System.out.println(getBinaryTreeNextNode(null));
        System.out.println(getBinaryTreeNextNode(node4).data);
        System.out.println(getBinaryTreeNextNode(node1).data);
        System.out.println(getBinaryTreeNextNode(node8).data);


    }

}
