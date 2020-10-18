package com.wdq.leetcode.algorithm;

import com.wdq.leetcode.BinaryTreePrinter.src.com.mj.printer.BinaryTrees;
import com.wdq.leetcode.algorithm.二叉树.二叉搜索树.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * #99 困难
 *
 *
 * @author wudq
 * @date 2020/10/17
 */
public class _99_恢复二叉搜索树 {
    private List<TreeNode> nodeList = new ArrayList<>();

    /**
     * 1、中序遍历，存放动态数组中（因为二叉搜索树中序遍历结果为升序）
     * 2、循环动态数组，发现相邻节点是逆序对（pre > next），记住逆序对的索引
     * 3、如果发现第二个逆序对，新逆序对的 next 替换之前的next，退出循环
     * 4、交换pre next 索引位置treeNode的val
     * @param root
     */
    public void recoverTree(TreeNode root) {
        int fi = -1;
        int ei = -1;
        inOrder(root);

        for (int j = 0; j < nodeList.size() - 1; j++) {
            if (nodeList.get(j).val > nodeList.get(j+1).val) {
                if (fi == -1) {
                    fi = j;
                    ei = j+1;
                } else {
                    ei = j+1;
                    break;
                }
            }
        }
        if (fi != -1) {
            int temp = nodeList.get(fi).val;
            nodeList.get(fi).val = nodeList.get(ei).val;
            nodeList.get(ei).val = temp;
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        nodeList.add(root);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] arrays = new Integer[]{3,1,4,null,null,2};
        for (Integer array : arrays) {
            bst.add(array);
        }
        BinaryTrees.println(bst);
    }

}

class _99_2 {

    TreeNode prev;

    TreeNode first;

    TreeNode second;

    /**
     * 1、中序遍历，存放动态数组中（因为二叉搜索树中序遍历结果为升序）
     * 2、循环动态数组，发现相邻节点是逆序对（pre > next），记住逆序对的索引
     * 3、如果发现第二个逆序对，新逆序对的 next 替换之前的next，退出循环
     * 4、交换pre next 索引位置treeNode的val
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * 中序遍历
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (prev != null && root.val < prev.val) {
            second = root;
            if (first != null) {
                return;
            }
            first = prev;
        }
        prev = root;
        inOrder(root.right);
    }
}
