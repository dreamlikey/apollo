package com.wdq.leetcode.algorithm.二叉树.二叉搜索树;

/**
 * @author wudq
 * @date 2020/7/2 0002
 * @Description: TODO
 */
public class 二叉搜索书遍历 {

    public void createBTree() {

    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }


    public void morris(TreeNode node) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] arrays = new Integer[]{7,4,9,2,5,8,11,1,3,6,10,12};
        for (Integer array : arrays) {
            bst.add(array);
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
