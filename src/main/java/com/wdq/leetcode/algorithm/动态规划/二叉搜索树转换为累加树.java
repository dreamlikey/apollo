package com.wdq.leetcode.algorithm.动态规划;


/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @author wudq
 * @date 2020/09/21
 */
public class 二叉搜索树转换为累加树 {
    static int max = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(13);
        root.left = left;
        root.right = right;
        postOrder(root);
        convertBST(root);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        max += root.val;
        root.val = max;
        convertBST(root.left);
        return root;
    }
    /**
     * 后序遍历
     */
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.right);
//        System.out.print(node.val + " ");
        max += node.val;
        node.val = max;
        System.out.print(node.val + " ");
        postOrder(node.left);
    }

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}