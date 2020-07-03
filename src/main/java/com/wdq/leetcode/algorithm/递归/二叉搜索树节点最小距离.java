package com.wdq.leetcode.algorithm.递归;

/**
 * @author wudq
 * @date 2020/7/2
 *
 * 二叉搜索树节点最小距离
 */
public class 二叉搜索树节点最小距离 {
    int min = Integer.MAX_VALUE;
    //前节点
    TreeNode pre;
    public static void main(String[] args) {

    }

    /**
     * 1、中序遍历整棵树
     * 2、比较差值
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }


    public void inorder(TreeNode root) {
        //没有子节点，返回上一层
        if (root == null) {
            return ;
        }
        /**
         * 递归遍历左节点，当当前节点是最后一个左节点递归返回上一层，继续向下执行
         */
        minDiffInBST(root.left);
        if (pre != null) {
            min = Math.min(root.val - pre.val, min);
        }
        pre = root;
        minDiffInBST(root.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
