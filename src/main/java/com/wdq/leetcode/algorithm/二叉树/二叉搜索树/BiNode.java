package com.wdq.leetcode.algorithm.二叉树.二叉搜索树;

/**
 * @author wudq
 * @date 2020/7/3
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，
 * 转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 */
public class BiNode {


    public Node convertBiNode(Node root) {
        return inOrder(root);
    }

    //记录上一个节点
    Node next = null;
    //递归 中序遍历
    public Node inOrder(Node root) {
        //节点为空返回上一层
        if (root == null) {
            return null;
        }
        //先遍历右节点
        inOrder(root.right);
        //节点-right 指向上一个节点
        root.right = next;
        //上一节点 修改为 当前节点
        next = root;
        inOrder(root.left);
        //节点-left 为空
        root.left = null;
        return next;
    }


    Node pre = null;
    //返回 尾节点
    public Node inOrder2(Node root) {
        if (root == null) {
            return null;
        }
        inOrder2(root.left);
        pre.right = root;
        pre = root;

        inOrder2(root.right);
        root.left = null;

        return root;
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x; }
    }
}



