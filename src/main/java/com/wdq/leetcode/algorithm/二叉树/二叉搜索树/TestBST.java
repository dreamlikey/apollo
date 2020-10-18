package com.wdq.leetcode.algorithm.二叉树.二叉搜索树;

import com.wdq.leetcode.BinaryTreePrinter.src.com.mj.printer.BinaryTrees;

/**
 * @author wudq
 * @date 2020/7/3 0003
 * @Description: TODO
 */
public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] arrays = new Integer[]{7,4,9,2,5,8,11,1,3,6,10,12};
        for (Integer array : arrays) {
            bst.add(array);
        }

//        System.out.println(bst.contains(13));
//
        BinarySearchTree<Integer> bstTree2 = getBST();
//
        // PrintStyle.LEVEL_ORDER（层序打印）
        BinaryTrees.println(bst);

        bst.postOrder(bst.getRoot());
    }

    public static BinarySearchTree getBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        // 二叉树的节点数量
//        int nodeCount = (int) (10 + Math.random() * 30);
        int nodeCount = (int) (100);
        for (int j = 0; j < nodeCount; j++) {
            double random = Math.random();
            // 每个节点的值
            int element = 0;
            if (random > 0.6) {
                element = (int) (Math.random() * 10000);
            } else if (random > 0.3) {
                element = (int) (Math.random() * 1000);
            } else {
                element = (int) (Math.random() * 100);
            }
            bst.add(element);
        }
        return bst;
    }
}
