package com.wdq.leetcode.algorithm;

/**
 *
 * @author wudq
 */
public class _333_最大BST子树 {

    /**
     * 最大BST子树<br/>
     * 自顶向下递归遍历
     * 存在重复判断
     * @param node
     * @return
     */
    public static int func(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (isBST(node)) {
            return nodesCount(node, 0);
        }
        return  Math.max(func(node.left), func(node.right));
    }

    /**
     * 是否是二叉搜索树
     * @param node
     * @return
     */
    private static boolean isBST(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.val < node.left.val || node.val > node.right.val) {
            return false;
        }
        isBST(node.left);
        isBST(node.right);
        return true;
    }

    /**
     * 节点数量
     * @param node
     * @param count
     * @return
     */
    private static int nodesCount(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        count++;
        count = nodesCount(node.left, count);
        count = nodesCount(node.right, count);

        return count;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
//        int count = nodesCount(node, 0);
//        System.out.println("count = " + count);
        int func = func(node);
        System.out.println("func = " + func);
    }
}


class _333_自底向上 {

    /**
     * 自底向上，动态规划思想（去掉重复计算）
     * @param node
     * @return
     */
    public int func(TreeNode node) {

        getInfo(node);


        return 0;
    }

    private int countBST(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        if (root.val > root.left.val && root.val < root.right.val) {
            count++;
        }
        count = countBST(root.left, count);
        count = countBST(root.right, count);
        return count;
    }

    private Info getInfo(TreeNode node) {
        Info li = getInfo(node.left);
        Info ri = getInfo(node.right);

        Info info = new Info();
        info.root = node;
        info.size = countBST(node, 0);

        return info;
    }

    static class Info {
        TreeNode root;
        int size = 1;
    }
}
